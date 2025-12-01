package com.mealmovers.service;

import com.mealmovers.model.Menu;
import java.util.List;

public interface MenuService {
    List<Menu> getMenuByRestaurantId(long restaurantId);
}
