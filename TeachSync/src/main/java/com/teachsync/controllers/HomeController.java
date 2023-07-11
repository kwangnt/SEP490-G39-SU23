package com.teachsync.controllers;

import com.teachsync.utils.Constants;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(
            HttpSession session,
            Model model,
            @ModelAttribute("mess") String mess) {
        model.addAttribute("mess", mess);

        

        return "index";
    }

    @GetMapping("/home")
    public String home1() {
        return "redirect:/";
    }
    @GetMapping("/index")
    public String home2() {
        return "redirect:/";
    }
    @GetMapping("/trang-chu")
    public String home3() {
        return "redirect:/";
    }
}
