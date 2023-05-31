package com.teachSync.teachSync.controllers;

import com.teachSync.teachSync.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        /* TODO: add to model */

        model.addAttribute("test", "testValue");

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        Object objUser = model.getAttribute("user");

        /* TODO: use DTO instead */
        if (objUser instanceof User) {
            /* Already login */
            return "index";
        }

        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {

        return "signup";
    }
}
