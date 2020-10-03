package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team team = new Team();
            team.setName("team");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.setAge(10);
            member.changeTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String query = "select CONCAT(m.username, m.age) from Member m";
            List<String> resultList = em.createQuery(query, String.class)
                    .getResultList();
            for (String test : resultList) {
                System.out.println(test);
            }

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
