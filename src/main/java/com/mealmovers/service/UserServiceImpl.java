
package com.mealmovers.service;

import com.mealmovers.dao.UserDao;
import com.mealmovers.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        userDao.save(user);
    }

    @Override
    public User authenticate(String email, String password) {
        User dbUser = userDao.getByEmail(email);

        if (dbUser == null) {
            return null;
        }

        if (dbUser.getPassword().equals(password)) {
            return dbUser;
        }

        return null;
    }
}
