package com.teachSync.teachSync.controllers;

import com.teachSync.teachSync.entities.User;
import com.teachSync.teachSync.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        try {
            User user = userService.login(username, password);

            if (user == null) {
                model.addAttribute("msg", "Incorrect username or password");
                return "login";
            }

            model.addAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
            return "login";
        }

        return "index";
    }

}
