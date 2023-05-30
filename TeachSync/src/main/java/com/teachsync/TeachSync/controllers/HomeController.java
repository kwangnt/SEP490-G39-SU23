package com.teachSync.teachSync.controllers;

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
}
