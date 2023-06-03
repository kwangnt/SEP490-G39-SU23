package com.teachsync.controllers;

import com.teachsync.entities.User;
import com.teachsync.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;



    @GetMapping("/login")
    public String login(Model model) {
        Object objUser = model.getAttribute("user");

        /* TODO: use DTO instead */
        if (objUser instanceof User) {
            /* Already login */
            return "redirect:/index";
        }

        return "login";
    }


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

    @GetMapping("/signup")
    public String signup(Model model) {

        return "signup";
    }

    @PostMapping("/signup")
    public String signup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullName,
            @RequestParam String email,
            Model model) {
        try {
            User user = new User(username, password, email, fullName);

            user = userService.signup(user);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            model.addAttribute("errorIllegalMsg", e.getMessage());
            return "signup";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
            return "signup";
        }

        return "login";
    }

}
