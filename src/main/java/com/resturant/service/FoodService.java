package com.resturant.service;

import com.resturant.Repository.FoodRepositoryImpl;
import com.resturant.Repository.FoodResporitory;
import com.resturant.model.Food;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class FoodService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql");
    private FoodResporitory foodResporitory = new FoodRepositoryImpl(emf , Food.class) ;
    public void addFood(String name , Double price , String category ) {
        Food food = new Food(name , category , price);
        foodResporitory.create(food);
    }
    public void updatePrice (Long id , Double newprice ) {
        foodResporitory.updatePrice(id, newprice);

    }

    public void updateName (Long id , String name ) {
        foodResporitory.updateName(id, name);

    }
    public void showMenu(){
        foodResporitory.findAll().forEach(System.out::println);
    }
    public void filterCategory(String category){
        List<Food> foods = foodResporitory.findAll().stream().filter(food -> food.getCategory().
                equalsIgnoreCase(category)).collect(Collectors.toList());
        foods.forEach(System.out::println);

    }
    public void deleteFood(Long id){
        foodResporitory.delete(id);
    }

}
