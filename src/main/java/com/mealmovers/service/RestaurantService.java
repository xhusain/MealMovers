package com.mealmovers.service;

import com.mealmovers.model.Restaurant;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(Long id);
}