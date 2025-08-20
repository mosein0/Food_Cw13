package com.resturant.Repository;

import com.resturant.base.BaseRepositoryImpl;
import com.resturant.model.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class FoodRepositoryImpl extends BaseRepositoryImpl<Food, Long> implements FoodResporitory {

    public FoodRepositoryImpl(EntityManagerFactory emf, Class<Food> entityClass) {
        super(emf, entityClass);
    }

    @Override
    public void updatePrice(Long id, Double newprice) {
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            Food food = em.find(Food.class, id);
            food.setPrice(newprice);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    @Override
    public void updateName(Long id, String name) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Food food = em.find(Food.class, id);
            food.setName(name);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }
}
