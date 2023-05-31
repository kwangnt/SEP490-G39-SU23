package com.teachSync.teachSync.services;

import com.teachSync.teachSync.entities.User;

public interface UserService {

    User login(String username, String password) throws Exception;


}
