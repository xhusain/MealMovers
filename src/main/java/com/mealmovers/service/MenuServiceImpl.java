package com.mealmovers.service;

import com.mealmovers.dao.MenuDAO;
import com.mealmovers.model.Menu;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuDAO menuDAO;

    public MenuServiceImpl(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public List<Menu> getMenuByRestaurantId(long restaurantId) {
        return menuDAO.getMenuByRestaurantId(restaurantId);
    }
}
