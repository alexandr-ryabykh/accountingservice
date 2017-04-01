package org.mainacad.security.service;

import org.mainacad.security.entity.User;
import org.mainacad.security.repository.RoleRepository;
import org.mainacad.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void edit(User user) {
        usersRepository.saveAndFlush(user);
    }

    @Override
    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Stream.of(roleRepository.findByName("USER")).collect(Collectors.toSet()));
        usersRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return usersRepository.findOne(id);
    }

    public User getAuthenticationUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return findByUsername(auth.getName());
    }


}
