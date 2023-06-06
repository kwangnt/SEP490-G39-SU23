package com.teachsync.services.user;

import com.teachsync.entities.User;

import java.util.List;

public interface UserService {

    User signup(User user) throws Exception;

    User login(String username, String password) throws Exception;

    List<User> getListUserByType(Long type);

}