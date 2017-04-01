package org.mainacad.security.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
