package com.teachsync.controllers;

import com.teachsync.entities.User;
import com.teachsync.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChildController {
    @Autowired
    private UserService us;

    @GetMapping("/listchild")
    public String lstChild(Model model) {
        try {
            List<User> lst = us.getListUserByType(2);
            model.addAttribute("lstUser", lst);
            System.out.println(lst);
            return "list-user";

        } catch (Exception e) {
            return "redirect:/index";
        }
    }

}
