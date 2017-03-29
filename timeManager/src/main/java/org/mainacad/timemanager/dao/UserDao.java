package org.mainacad.timemanager.dao;


import org.mainacad.timemanager.model.User;

import java.util.List;

public interface UserDao {
    public List<User> listUsers();

    public User addUser(User user);

    public void deleteUser(long userId);

    public User getUser(long userId);
}
