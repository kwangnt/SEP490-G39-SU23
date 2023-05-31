package com.teachsync.services.user;

import com.teachsync.entities.User;

public interface UserService {

    User signup(User user) throws Exception;

    User login(String username, String password) throws Exception;

}