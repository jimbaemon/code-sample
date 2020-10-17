package study.querydsl;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;
import study.querydsl.entity.Team;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static study.querydsl.entity.QMember.member;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before(){
        queryFactory = new JPAQueryFactory(em);

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

    }

    @Test
    public void startJPQL(){
        //member1을 찾아라.
        String searchMem = "member1' OR 'test' = 'test";
        Member findMember = em.createQuery("select m from Member m where m.username = '" + searchMem + "'", Member.class)
                .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }
    
    @Test
    public void startQuerydsl(){

        //member1을 찾아라.
        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(
                        member.username.eq("member1"),
                        member.age.eq(10).or(member.age.eq(20))
                )
                .fetchOne();
/*
        member.username.eq("member1"); //username = 'member1'
        member.username.ne("member1"); //username != 'member1'
        member.username.eq("member1").not(); //username != 'member1'

        member.username.isNull(); // member is null
        member.username.isNotNull(); // member is Not Null

        member.username.isEmpty(); // empty(username)
        member.username.isNotEmpty(); //not empty(username)

        member.age.in(10, 20); // age in ('10', '20')
        member.age.notIn(10, 20); // age not in ('10', '20')
        member.age.between(10, 20); //age between 10 and 20

        member.age.goe(30); // age >= 30
        member.age.gt(30); // age > 30
        member.age.loe(30); // age <= 30
        member.age.lt(30); // age < 30

        member.username.like("member%"); // username like 'member%'
        member.username.contains("member"); // username contains("member")
        member.username.startsWith("member"); // username like 'member%'*/


        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void resultFetch(){
        //목록 조회
        List<Member> fetch = queryFactory
                .selectFrom(member)
                .fetch();

        //단건 조회 두건이상일 경우 Exception
        Member fetchOne = queryFactory
                .selectFrom(member)
                .fetchOne();

        //목록중 한건 조회 limit(1).fetchOne(); 과 동일
        Member fetchFirst = queryFactory
                .selectFrom(member)
                .fetchFirst();

        QueryResults<Member> memberQueryResults = queryFactory
                .selectFrom(member)
                .fetchResults();

        queryFactory
                .selectFrom(member)
                .fetchCount();

    }
}
