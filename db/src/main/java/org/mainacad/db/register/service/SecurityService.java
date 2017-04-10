package org.mainacad.db.register.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
