package com.mealmovers.dao;

import com.mealmovers.model.User;

public interface UserDao {
    void save(User user);
    User getByEmail(String email);
}