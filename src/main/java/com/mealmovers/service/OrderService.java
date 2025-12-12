package com.mealmovers.service;

import com.mealmovers.model.OwnerOrderDTO;
import java.util.List;

public interface OrderService {
    Long createOrderFromCart(Long userId, String paymentMethod);
    List<OwnerOrderDTO> getOrdersForOwner(Long ownerId);

}
