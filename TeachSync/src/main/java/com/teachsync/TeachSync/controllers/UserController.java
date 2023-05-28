package com.teachSync.teachSync.controllers;

import com.teachSync.teachSync.entities.User;
import com.teachSync.teachSync.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {
        String s = "login fail";
        try {
            User user = userService.login(username, password);

            if (user != null) {
                s = "Login success";
            }

        } catch (Exception e)  {
            e.printStackTrace();
        }

        return s;
    }


}
