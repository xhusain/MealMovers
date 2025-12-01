package com.mealmovers.model;

import java.math.BigDecimal;

public class Menu {
    private long menuId;
    private long restaurantId;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available;

    public long getMenuId() { return menuId; }
    public void setMenuId(long menuId) { this.menuId = menuId; }

    public long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(long restaurantId) { this.restaurantId = restaurantId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
