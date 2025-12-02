package com.mealmovers.service;

import com.mealmovers.model.CartItem;
import java.util.List;

public interface CartService {
    void addToCart(Long menuId, int quantity);
    List<CartItem> getCartItems();
    void updateQuantity(Long cartId, int quantity);
    void removeItem(Long cartId);
    void clearCart();

    public List<CartItem> getCartByUserId(Long userId);
}
