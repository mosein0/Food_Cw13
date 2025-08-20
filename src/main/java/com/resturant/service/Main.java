package com.resturant.service;

import com.resturant.Repository.FoodRepositoryImpl;
import com.resturant.Repository.FoodResporitory;
import com.resturant.model.Food;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql");
        FoodService test = new FoodService();
        test.addFood("pizza " , 450.000 , "fastFood");
        test.addFood("burger " , 340.000 , "fastFood");
        test.addFood("kebab " , 150.000 , "traditional");
        test.addFood("grilled salmon " , 150.000 , "seafood");
        test.addFood("grilled salmon " , 150.000 , "test");
        System.out.println("************************");
        test.showMenu();
        System.out.println("***********************");

        /*test.updateName(1L, "hosein");
        test.updatePrice(2L , 140D);
        test.deleteFood(3L);*/
        test.filterCategory("seafood");

    }
}
