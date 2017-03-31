package org.mainacad.db.register.service;




import lombok.Setter;
import org.mainacad.db.register.domain.User;
import org.mainacad.db.register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Setter
    private UserRepository userRepository;

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);    }

    @Override
    public void deleteUser(long userId) {
        userRepository.delete(userId);
    }

    @Override
    public User getUser(long userId) {
        return userRepository.findOne(userId);
    }
}
