package com.resturant.model;

import com.resturant.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table (name = "food_table")
public class Food extends BaseEntity<Long> {
    private String name , category ;
    private Double price;

    public Food(String name, String category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Food() {
    }




    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
