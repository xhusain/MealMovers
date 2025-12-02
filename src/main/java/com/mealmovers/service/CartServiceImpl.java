package com.mealmovers.service;

import com.mealmovers.dao.CartDAO;
import com.mealmovers.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;

    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    public void addToCart(Long menuId, int quantity) {
        cartDAO.addToCart(menuId, quantity);
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartDAO.getCartItems();
    }

    @Override
    public void updateQuantity(Long cartId, int quantity) {
        cartDAO.updateQuantity(cartId, quantity);
    }

    @Override
    public void removeItem(Long cartId) {
        cartDAO.removeItem(cartId);
    }

    @Override
    public void clearCart() {
        cartDAO.clearCart();
    }

    @Override
    public List<CartItem> getCartByUserId(Long userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
