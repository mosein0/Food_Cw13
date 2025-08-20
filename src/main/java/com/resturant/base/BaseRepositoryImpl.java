package com.resturant.base;

import com.resturant.model.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class BaseRepositoryImpl<T extends BaseEntity <ID>, ID> implements BaseRepository<T , ID> {
   protected EntityManagerFactory emf ;

   protected Class<T> entityClass;

    public BaseRepositoryImpl(EntityManagerFactory emf, Class<T> entityClass) {
        this.emf = emf;
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void delete(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find( entityClass, id));
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public T findById(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T entity = em.find( entityClass, id );
        em.getTransaction().commit();
        em.close();
       return entity;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            List<T> result = em.createQuery("select o from "+entityClass.getName()+" o").getResultList();
            em.getTransaction().commit();
            return result;
        }catch( Exception e ){
            return new ArrayList<>();

        }finally {
            em.close();
        }

    }
}
