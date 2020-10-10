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

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(20); //얘 20
            member.changeTeam(team);

            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20); //얘도 20
            member2.changeTeam(team);

            em.persist(member2);

            //UPDATE 전부 열살로 변경
            String upQuery = "Update Member m " +
                    "set m.age = 10 " +
                    "WHERE m.team = :team";
            int upCount = em.createQuery(upQuery)
                    .setParameter("team", team)
                    .executeUpdate();

            em.clear();

            List<Member> resultList = em.createQuery("SELECT m FROM Member m", Member.class)
                    .getResultList();

            System.out.println("resultList = " + resultList);

            //INSERT
            /*String insQuery = "INSERT INTO MemberTemp(id, username, age) " +
                    "SELECT m.id, m.username, m.age FROM Member m " +
                    "WHERE m.team = :team";
            int insCount = em.createQuery(insQuery)
                    .setParameter("team", team)
                    .executeUpdate();*/

            //DELETE
            /*String delQuery = "DELETE FROM Member m WHERE m.team = :team";
            int delCount = em.createQuery(delQuery)
                    .setParameter("team", team)
                    .executeUpdate();*/



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
