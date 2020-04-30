package repo;

import entity.Artist;
import entity.Chart;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ChartRepositoryJPA implements AbstractRepository<Chart> {
    private EntityManagerFactory entityManagerFactory= PersistenceUtil.getInstance().returnEntity();

    public ChartRepositoryJPA() {
    }
    @Override
    public void create(Chart chart) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(chart);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public Chart findById(int id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Chart chart= entityManager.find(Chart.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return chart;
    }
    @Override
    public List<Chart> findByName(String name) {
        return null;
    }
    public List<Chart> listBestAlbums(int limit){
        List<Chart> list;
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        list=entityManager.createNamedQuery("listBestAlbums",Chart.class).setMaxResults(limit).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }
    @Override
    public List<Chart> getAll()
    {
        List<Chart> chartList;
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        chartList=entityManager.createNamedQuery("getAll",Chart.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return chartList;
    }
}
