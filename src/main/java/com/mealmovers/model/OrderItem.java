package com.mealmovers.model;

import java.math.BigDecimal;

public class OrderItem {
    private long orderItemId;
    private long orderId;
    private long menuId;
    private int qty;
    private BigDecimal price;

    public long getOrderItemId() { return orderItemId; }
    public void setOrderItemId(long orderItemId) { this.orderItemId = orderItemId; }

    public long getOrderId() { return orderId; }
    public void setOrderId(long orderId) { this.orderId = orderId; }

    public long getMenuId() { return menuId; }
    public void setMenuId(long menuId) { this.menuId = menuId; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
