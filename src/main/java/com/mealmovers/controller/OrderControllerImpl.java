/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mealmovers.controller;

import com.mealmovers.service.CartService;
import com.mealmovers.service.OrderService;


public class OrderControllerImpl extends OrderController {

    public OrderControllerImpl(CartService cartService, OrderService orderService) {
        super(cartService, orderService);
    }
    
}
