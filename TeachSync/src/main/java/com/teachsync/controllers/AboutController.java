package com.teachsync.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
    @GetMapping("")
    public String about() {
        /* TODO: add news, promotion,... to model */
        return "about";
    }
}
