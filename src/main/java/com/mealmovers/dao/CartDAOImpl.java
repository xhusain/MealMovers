package com.mealmovers.dao;

import com.mealmovers.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAOImpl implements CartDAO {

    private final JdbcTemplate jdbcTemplate;

    public CartDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addToCart(Long menuId, int quantity) {
        String sql = "INSERT INTO cart (menu_id, quantity) VALUES (?, ?)";
        jdbcTemplate.update(sql, menuId, quantity);
    }

    @Override
    public List<CartItem> getCartItems() {
        String sql = "SELECT c.cart_id, m.menu_id, m.name, m.price, c.quantity " +
                     "FROM cart c JOIN menus m ON c.menu_id = m.menu_id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CartItem item = new CartItem();
            item.setCartId(rs.getLong("cart_id"));
            item.setMenuId(rs.getLong("menu_id"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setQuantity(rs.getInt("quantity"));
            return item;
        });
    }

    @Override
    public void updateQuantity(Long cartId, int quantity) {
        String sql = "UPDATE cart SET quantity = ? WHERE cart_id = ?";
        jdbcTemplate.update(sql, quantity, cartId);
    }

    @Override
    public void removeItem(Long cartId) {
        String sql = "DELETE FROM cart WHERE cart_id = ?";
        jdbcTemplate.update(sql, cartId);
    }

    @Override
    public void clearCart() {
        String sql = "DELETE FROM cart";
        jdbcTemplate.update(sql);
    }
}
