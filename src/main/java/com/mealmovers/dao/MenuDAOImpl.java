package com.mealmovers.dao;

import com.mealmovers.model.Menu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuDAOImpl implements MenuDAO {

    private final JdbcTemplate jdbcTemplate;

    public MenuDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Menu> getMenuByRestaurantId(long restaurantId) {
        String sql = "SELECT * FROM menus WHERE restaurant_id = ?";
        return jdbcTemplate.query(sql, new Object[]{restaurantId}, new RowMapper<Menu>() {
            @Override
            public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
                Menu menu = new Menu();
                menu.setMenuId(rs.getLong("menu_id"));
                menu.setRestaurantId(rs.getLong("restaurant_id"));
                menu.setName(rs.getString("name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getBigDecimal("price"));
                menu.setAvailable(rs.getBoolean("available"));
                return menu;
            }
        });
    }
}
