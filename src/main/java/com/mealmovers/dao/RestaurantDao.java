package com.mealmovers.dao;

import com.mealmovers.model.Restaurant;
import java.util.List;

public interface RestaurantDao {
    List<Restaurant> findAll();
    Restaurant findById(Long id);
}