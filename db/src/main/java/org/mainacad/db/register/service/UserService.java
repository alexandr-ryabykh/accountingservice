package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.UserTM;

public interface UserService {
    public Iterable<UserTM> listUsers();

    public void addUser(UserTM userTM);

    public void deleteUser(long userId);

    public UserTM getUser(long userId);
}
