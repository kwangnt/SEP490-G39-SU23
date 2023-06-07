package com.teachSync.teachSync.services;

import com.teachSync.teachSync.entities.User;
import com.teachSync.teachSync.reposirories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public User login(String username, String password) throws Exception {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);

        return user.orElse(null);

    }
}
