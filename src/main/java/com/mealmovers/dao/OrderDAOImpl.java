package com.mealmovers.dao;

import com.mealmovers.model.CartItem;
import com.mealmovers.model.OwnerOrderDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private final JdbcTemplate jdbc;
    private final CartDAO cartDAO;

    public OrderDAOImpl(JdbcTemplate jdbc, CartDAO cartDAO) {
        this.jdbc = jdbc;
        this.cartDAO = cartDAO;
    }

    @Override
    public Long createOrderFromCart(Long userId, String paymentMethod) {

        // Fetch all cart items (your cart is global)
        List<CartItem> items = cartDAO.getCartItems();
        if (items == null || items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        // Compute total price
        double total = items.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();

        // Determine restaurant_id for the order
        // Take it from the first item
        Long tempRestaurantId;
        try {
            Long firstMenuId = items.get(0).getMenuId();
            String sql = "SELECT restaurant_id FROM menus WHERE menu_id = ?";
            tempRestaurantId = jdbc.queryForObject(sql, Long.class, firstMenuId);

            if (tempRestaurantId == null) {
                throw new IllegalStateException("Restaurant not found for menuId: " + firstMenuId);
            }

        } catch (Exception ex) {
            throw new IllegalStateException("Failed to find restaurant_id: " + ex.getMessage(), ex);
        }

        // must be final for lambda
        final Long restaurantId = tempRestaurantId;

        // Insert into orders
        final String insertOrderSql =
                "INSERT INTO orders (user_id, restaurant_id, total_amount, status) VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    insertOrderSql,
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setLong(1, userId);
            ps.setLong(2, restaurantId);
            ps.setBigDecimal(3, new java.math.BigDecimal(String.format("%.2f", total)));
            ps.setString(4, "PLACED");
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key == null) {
            throw new IllegalStateException("Order creation failed");
        }

        Long orderId = key.longValue();

        // Insert each cart item into order_items
        final String insertItemSql =
                "INSERT INTO order_items (order_id, menu_id, qty, price) VALUES (?, ?, ?, ?)";

        for (CartItem item : items) {
            jdbc.update(insertItemSql,
                    orderId,
                    item.getMenuId(),
                    item.getQuantity(),
                    item.getPrice()
            );
        }

        // Clear cart after successful order
        cartDAO.clearCart();

        return orderId;
    }
    
    @Override
    public List<OwnerOrderDTO> getOrdersForOwner(Long ownerId) {

    String sql =
        "SELECT o.order_id, o.user_id, u.name AS customer_name, " +
        "o.total_amount, o.status, o.created_at " +
        "FROM orders o " +
        "JOIN restaurants r ON o.restaurant_id = r.restaurant_id " +
        "JOIN users u ON o.user_id = u.user_id " +
        "WHERE r.owner_id = ? " +
        "ORDER BY o.order_id DESC";
          
    return jdbc.query(sql, (rs, rowNum) -> {
        OwnerOrderDTO dto = new OwnerOrderDTO();
        dto.setOrderId(rs.getLong("order_id"));
        dto.setUserId(rs.getLong("user_id"));
        dto.setCustomerName(rs.getString("customer_name"));
        dto.setTotalAmount(rs.getDouble("total_amount"));
        dto.setStatus(rs.getString("status"));
        dto.setCreatedAt(rs.getString("created_at"));
        return dto;
    }, ownerId);
}

}
