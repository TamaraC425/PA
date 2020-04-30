package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumRepositoryJPA implements AbstractRepository<Album> {
    private EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance().returnEntity();


    public AlbumRepositoryJPA() {
    }

    @Override
    public void create(Album album) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Album findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Album album = entityManager.find(Album.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return album;
    }

    @Override
    public List<Album> findByName(String name) {
        List<Album> albumList;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        albumList = entityManager.createNamedQuery("findAlbumByName", Album.class).setParameter("name", name).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return albumList;
    }

    public List<Album> findByArtist(Artist artist) {
        List<Album> albumList;
        int artistId = artist.getId();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        albumList = entityManager.createNamedQuery("findByArtist", Album.class).setParameter("artistId", artistId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return albumList;
    }
    @Override
    public List<Album> getAll()
    {
        List<Album> albumList;
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        albumList=entityManager.createNamedQuery("getAlbums",Album.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return albumList;
    }
}
