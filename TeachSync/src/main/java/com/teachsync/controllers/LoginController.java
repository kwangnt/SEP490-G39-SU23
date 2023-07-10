package com.teachsync.controllers;

import com.teachsync.dtos.user.UserCreateDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;



    @GetMapping("/sign-in")
    public String login(HttpSession session) {
        Object objUser = session.getAttribute("user");

        if (objUser instanceof UserReadDTO) {
            /* Already login */
            return "redirect:/index";
        }

        return "login";
    }


    @PostMapping("/sign-in")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session,
            @SessionAttribute(required = false) String targetUrl) {
        try {
            UserReadDTO user = userService.loginDTO(username, password);

            if (user == null) {
                model.addAttribute("msg", "Incorrect username or password");
                return "login";
            }

            session.setAttribute("user", user);

            if (targetUrl != null) {
                /* Quay lại trang cũ sau login */
                return "redirect:" + targetUrl;
            }
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("msg", e.getMessage());
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "login";
        }

        return "redirect:/index";
    }

    @GetMapping("/sign-up")
    public String signup(Model model) {
        return "signup";
    }

    @PostMapping("/sign-up")
    public String signup(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullName,
            @RequestParam String email,
            Model model) {
        try {
            UserCreateDTO createDTO = new UserCreateDTO(username, password, email, fullName);

            UserReadDTO readDTO = userService.signupDTO(createDTO);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            model.addAttribute("errorIllegalMsg", e.getMessage());
            return "signup";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
            return "signup";
        }

        return "redirect:/login";
    }

    @GetMapping("/sign-out")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}
