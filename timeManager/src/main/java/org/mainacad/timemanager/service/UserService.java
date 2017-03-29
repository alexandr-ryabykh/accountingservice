package org.mainacad.timemanager.service;


import org.mainacad.timemanager.model.User;

import java.util.List;

public interface UserService {
    public List <User> listUsers();

    public User addUser(User user);

    public void deleteUser(long userId);

    public User getUser(long userId);
}
