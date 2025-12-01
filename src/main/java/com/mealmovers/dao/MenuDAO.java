package com.mealmovers.dao;

import com.mealmovers.model.Menu;
import java.util.List;

public interface MenuDAO {
    List<Menu> getMenuByRestaurantId(long restaurantId);
}
