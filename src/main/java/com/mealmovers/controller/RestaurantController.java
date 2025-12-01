package com.mealmovers.controller;

import com.mealmovers.model.Menu;
import com.mealmovers.model.Restaurant;
import com.mealmovers.service.MenuService;
import com.mealmovers.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuService menuService;

    // Constructor injection for services
    public RestaurantController(RestaurantService restaurantService, MenuService menuService) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
    }

    // List all restaurants
    @GetMapping("/restaurants")
    public String listRestaurants(Model model) {
        List<Restaurant> list = restaurantService.getAllRestaurants();
        model.addAttribute("restaurants", list);
        return "restaurants"; // Resolves to /WEB-INF/views/restaurants.jsp
    }

    // View restaurant's menu
    @GetMapping("/restaurants/{id}/menu")
    public String viewMenu(@PathVariable("id") Long id, Model model) {
        // Fetch restaurant details by ID
        Restaurant restaurant = restaurantService.getRestaurantById(id);

        // Fetch menu items for the given restaurant
        List<Menu> menuItems = menuService.getMenuByRestaurantId(id);

        // Add attributes to the model for rendering in the view
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("menuItems", menuItems);

        return "menu"; // Resolves to /WEB-INF/views/menu.jsp
    }
}