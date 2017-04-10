package org.mainacad.db.register.service;

import org.mainacad.db.register.domain.User;

public interface UsersService {
    void edit(User user);

    void save(User user);

    User findByUsername(String username);

    User findById(Long id);

    public User getAuthenticationUser();

}
