package com.teachSync.teachSync.controllers;

import com.teachSync.teachSync.entities.User;
import com.teachSync.teachSync.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
//        ModelAndView mAV = new ModelAndView("redirect:/login");
        try {
            User user = userService.login(username, password);

            if (user == null) {
                model.addAttribute("msg", "Not found");
            }

            model.addAttribute("user", user);

        } catch (Exception e)  {
            e.printStackTrace();
            model.addAttribute("msg", "error");
        }

        return "login";
    }


}
