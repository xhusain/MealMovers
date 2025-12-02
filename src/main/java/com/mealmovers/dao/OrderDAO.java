package com.mealmovers.dao;

public interface OrderDAO {
    /**
     * Create an order from current cart contents.
     * Uses userId (saved in session) and paymentMethod string.
     * Returns generated order_id.
     */
    Long createOrderFromCart(Long userId, String paymentMethod);
}
