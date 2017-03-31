package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.User;



public interface UserService {
    public Iterable <User> listUsers();

    public void addUser(User user);

    public void deleteUser(long userId);

    public User getUser(long userId);
}
