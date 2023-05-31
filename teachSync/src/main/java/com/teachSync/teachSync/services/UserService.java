package com.teachSync.teachSync.services;

import com.teachSync.teachSync.entities.User;

public interface UserService {

    User signup(User user) throws Exception;

    User login(String username, String password) throws Exception;


}
