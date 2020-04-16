package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ArtistRepository {
    private EntityManagerFactory entityManagerFactory= PersistenceUtil.getInstance().returnEntity();

    public ArtistRepository() {
    }
    public void create(Artist artist) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Artist findById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist artist= entityManager.find(Artist.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return artist;
    }
    public Artist findByName(String name) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist artist=entityManager.createNamedQuery("findByName",Artist.class).setParameter("name",name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return artist;
    }
}
