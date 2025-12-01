package com.mealmovers.dao;

import com.mealmovers.model.Restaurant;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

    private final JdbcTemplate jdbcTemplate;

    public RestaurantDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Restaurant> findAll() {
        String sql = "SELECT restaurant_id, owner_id, name, address, phone FROM restaurants";
        return jdbcTemplate.query(sql, new RestaurantRowMapper());
    }

    @Override
    public Restaurant findById(Long id) {
        String sql = "SELECT restaurant_id, owner_id, name, address, phone FROM restaurants WHERE restaurant_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RestaurantRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static class RestaurantRowMapper implements RowMapper<Restaurant> {
        @Override
        public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Restaurant r = new Restaurant();
            r.setRestaurantId(rs.getLong("restaurant_id"));
            r.setOwnerId(rs.getLong("owner_id"));
            r.setName(rs.getString("name"));
            r.setAddress(rs.getString("address"));
            r.setPhone(rs.getString("phone"));
            return r;
        }
    }
}
