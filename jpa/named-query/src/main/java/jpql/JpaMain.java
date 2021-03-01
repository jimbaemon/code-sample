package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.changeTeam(team);

            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20);
            member2.changeTeam(team);

            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setAge(20);
            member3.changeTeam(team2);

            em.persist(member3);


            em.flush();
            em.clear();

            List<Member> findMembers = em.createNamedQuery("Member.findByUsername", Member.class) //구현해둔 Named Query의 name 호출
                    .setParameter("username", member.getUsername()) //파라미터 전달
                    .getResultList();

            System.out.println("findMembers = " + findMembers);

            List<Member> findMembersXml = em.createNamedQuery("Member.findByUserNameXml", Member.class) //구현해둔 Named Query의 name 호출
                    .setParameter("username", member.getUsername()) //파라미터 전달
                    .getResultList();

            System.out.println("findMembersXml = " + findMembersXml);

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
            //code
            e.printStackTrace();
            em.close();
        }
        emf.close();
    }
}
