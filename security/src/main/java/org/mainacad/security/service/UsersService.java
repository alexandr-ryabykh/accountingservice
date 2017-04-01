package org.mainacad.security.service;

import org.mainacad.security.entity.User;

public interface UsersService {
    void edit(User user);

    void save(User user);

    User findByUsername(String username);

    User findById(Long id);

    public User getAuthenticationUser();

}
