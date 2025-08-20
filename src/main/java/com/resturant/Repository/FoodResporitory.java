package com.resturant.Repository;

import com.resturant.base.BaseRepository;
import com.resturant.model.Food;

public interface FoodResporitory extends BaseRepository<Food, Long> {
    void updatePrice (Long id , Double newprice);
    void updateName(Long id , String name);
}
