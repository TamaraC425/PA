package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ArtistRepositoryJPA implements AbstractRepository<Artist> {
    private EntityManagerFactory entityManagerFactory= PersistenceUtil.getInstance().returnEntity();

    public ArtistRepositoryJPA() {
    }
    @Override
    public void create(Artist artist) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public Artist findById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Artist artist= entityManager.find(Artist.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return artist;
    }
    @Override
    public List<Artist> findByName(String name) {
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Artist> artistList=entityManager.createNamedQuery("findArtistByName",Artist.class).setParameter("name",name).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return artistList;
    }
    @Override
    public List<Artist> getAll()
    {
        List<Artist> artistList;
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        artistList=entityManager.createNamedQuery("getArtists",Artist.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return artistList;
    }
}