package com.mealmovers.service;

import com.mealmovers.dao.RestaurantDao;
import com.mealmovers.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantDao restaurantDao;

    public RestaurantServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantDao.findById(id);
    }
}