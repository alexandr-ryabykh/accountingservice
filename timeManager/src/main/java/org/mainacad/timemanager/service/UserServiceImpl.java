package org.mainacad.timemanager.service;


import org.mainacad.timemanager.dao.UserDao;
import org.mainacad.timemanager.dao.impl.UserDaoImpl;
import org.mainacad.timemanager.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setStudentDAO(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public User getUser(long userId) {
        return null;
    }
}
