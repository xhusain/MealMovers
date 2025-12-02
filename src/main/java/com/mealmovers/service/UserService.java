package com.mealmovers.service;

import com.mealmovers.model.User;

public interface UserService {
    void registerUser(User user);
    User authenticate(String email, String password);
}