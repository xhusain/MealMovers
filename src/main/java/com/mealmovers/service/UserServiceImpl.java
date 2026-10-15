
package com.mealmovers.service;

import com.mealmovers.dao.UserDao;
import com.mealmovers.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User authenticate(String email, String password) {
        User dbUser = userDao.getByEmail(email);

        if (dbUser == null) {
            return null;
        }

        if (passwordEncoder.matches(password, dbUser.getPassword())) {
            return dbUser;
        }

        return null;
    }
}
