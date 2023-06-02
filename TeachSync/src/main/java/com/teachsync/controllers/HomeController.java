package com.teachsync.controllers;

import com.teachsync.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model) {
        /* TODO: add news, promotion,... to model */

        return "index";
    }
}
