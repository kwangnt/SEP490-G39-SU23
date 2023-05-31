package com.teachSync.teachSync.services;

import com.teachSync.teachSync.entities.User;
import com.teachSync.teachSync.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User signup(User user) throws Exception {
        boolean isExists = userRepository.existsByUsernameAndStatusNot(user.getUsername(), "DELETED");
        if (isExists) {
            throw new IllegalArgumentException("Already exists account with username: " + user.getUsername());
        }

        user = userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public User login(String username, String password) throws Exception {
        Optional<User> user =
                userRepository.findByUsernameAndPasswordAndStatusNot(username, password, "DELETED");

        return user.orElse(null);
    }
}
