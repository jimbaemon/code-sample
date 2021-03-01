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

            // ######## 엔티티 직접 사용 기본키 #########
            String query = "SELECT COUNT(m.id) FROM Member m";
            Long result = em.createQuery(query, Long.class)
                    .getSingleResult();

            System.out.println("예시1 = " + result);

            String query2 = "SELECT COUNT(m) FROM Member m";
            Long result2 = em.createQuery(query2, Long.class)
                    .getSingleResult();

            System.out.println("예시2 = " + result2);

            String query3 = "SELECT m FROM Member m WHERE m = :setMember";
            Member findMember = em.createQuery(query3, Member.class)
                    .setParameter("setMember", member)
                    .getSingleResult();

            System.out.println("findMember = " + findMember);

            // ######## 엔티티 직접 사용 외래키 #########
            String query4 = "SELECT m FROM Member m WHERE m.team.id = :teamid";
            List<Member> findMember2 = em.createQuery(query4, Member.class)
                    .setParameter("teamid", team.getId())
                    .getResultList();
            System.out.println("findMember2 = " + findMember2);

            String query5 = "SELECT m FROM Member m WHERE m.team = :setTeam";
            List<Member> findMember3 = em.createQuery(query5, Member.class)
                    .setParameter("setTeam", team)
                    .getResultList();
            System.out.println("findMember3 = " + findMember3);

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
