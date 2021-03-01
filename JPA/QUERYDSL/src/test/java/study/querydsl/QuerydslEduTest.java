package study.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;
import study.querydsl.entity.QMember;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

import static study.querydsl.entity.QMember.*;

@SpringBootTest
@Transactional
public class QuerydslEduTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void beforeEach(){
        queryFactory = new JPAQueryFactory(em);
        Member member = new Member("이름", 10);
        em.persist(member);
    }

    @Test
    public void booleanBuilder_test(){
        Integer paramAge = null;

        //1. BooleanBuilder 초기화
        BooleanBuilder builder = new BooleanBuilder();

        //2. 조건절 생성
        if(paramAge == null){
            //3. builder 에 조건절 추가
            builder.and(member.age.eq(10));
        }

        Member findMember = queryFactory
                .selectFrom(member)
                .where(builder) //4. queryFactory 조건절에 builder 추가
                .fetchFirst();

        System.out.println("member = " + findMember);
    }

    @Test
    public void whereMultiParams(){
        String findName = null;

        List<Member> findMembers = queryFactory
                .selectFrom(member)
                .where(usernameEq(findName)) //2. 조건 절에서 반환 함수 호출
                .fetch();

        System.out.println("findMembers = " + findMembers);
    }

@Test
public void whereUsernameAndAge(){
    String findName = "이름";
    Integer findAge = 10;

    List<Member> findMembers = queryFactory
            .selectFrom(member)
            .where(allEq(findName, findAge)) // 찾을 조건을 쉼표(,)로 이어 붙이면 된다
            .fetch();

    System.out.println("findMembers = " + findMembers);
}

//기존 함수 재사용
private BooleanExpression usernameEq(String findName){
    return findName == null?null:member.username.eq(findName);
}

//나이를 찾는 함수 추가
private BooleanExpression ageEq(Integer findAge){
    return findAge == null?member.age.eq(10):member.age.eq(findAge);
}

//위의 두 함수를 합치는 함수
private BooleanExpression allEq(String findName, Integer findAge){
    return usernameEq(findName).and(ageEq(findAge));
}
}
