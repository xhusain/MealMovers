package com.mealmovers.service;

import com.mealmovers.dao.OrderDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public Long createOrderFromCart(Long userId, String paymentMethod) {
        return orderDAO.createOrderFromCart(userId, paymentMethod);
    }
}
