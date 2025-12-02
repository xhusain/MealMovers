package com.mealmovers.service;

public interface OrderService {
    Long createOrderFromCart(Long userId, String paymentMethod);
}
