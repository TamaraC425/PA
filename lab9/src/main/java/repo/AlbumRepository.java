package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlbumRepository {
    private EntityManagerFactory entityManagerFactory= PersistenceUtil.getInstance().returnEntity();


    public AlbumRepository() {
    }
    public void create(Album album) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Album findById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Album album=entityManager.find(Album.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return album;
    }
    public Album findByName(String name) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Album album=entityManager.createNamedQuery("findByName",Album.class).setParameter("name",name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return album;
    }
    public List<Album> findByArtist(Artist artist) {
        List<Album> albumList;
        int artistId=artist.getId();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        albumList=entityManager.createNamedQuery("findByArtist",Album.class).setParameter("artistId",artistId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return albumList;
    }
}
