package player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import player.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class PlayerRepository {
private EntityManagerFactory entityManagerFactory;
public PlayerRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        }
public void create(Player player) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.getTransaction().commit();
        entityManager.close();
        }
public String listPlayers() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select p from Player p");
        List<Player> playerList = query.getResultList();
        entityManager.close();
        return playerList.toString();
        }
public void update(String name,String newName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Player p set p.name =:playerName  where p.name = :player");
        query.setParameter("player", name);
        query.setParameter("playerName", newName);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        }
public void delete(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
        "DELETE FROM Player p WHERE p.id = :iid ");
        query.setParameter("iid", id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        }
}
