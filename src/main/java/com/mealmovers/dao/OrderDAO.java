package com.mealmovers.dao;

import com.mealmovers.model.OwnerOrderDTO;
import java.util.List;

public interface OrderDAO {
    /**
     * Create an order from current cart contents.
     * Uses userId (saved in session) and paymentMethod string.
     * Returns generated order_id.
     */
    Long createOrderFromCart(Long userId, String paymentMethod);
    List<OwnerOrderDTO> getOrdersForOwner(Long ownerId);

}
