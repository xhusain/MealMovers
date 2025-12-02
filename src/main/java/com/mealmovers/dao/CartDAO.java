package com.mealmovers.dao;

import com.mealmovers.model.CartItem;
import java.util.List;

public interface CartDAO {
    void addToCart(Long menuId, int quantity);
    List<CartItem> getCartItems();
    void updateQuantity(Long cartId, int quantity);
    void removeItem(Long cartId);
    void clearCart();
}
