package com.teachsync.controllers;

import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.User;
import com.teachsync.services.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChildController {

    @Autowired
    UserService userService;

    @GetMapping("/listchild")
    public String lstChild(Model model, HttpSession session) {
        UserReadDTO user = (UserReadDTO) session.getAttribute("user");
        if (user == null || user.getRoleId() != 4
        ) {
            return "redirect:/";
        }
        List<User> lst = userService.getListUserByType(2L);
        model.addAttribute("lstUser", lst);
        if (lst.isEmpty()) {
            System.out.println("khong tim thay du lieu");
        } else {
            System.out.println(lst);
        }
        return "list-user";
    }

    @GetMapping("/searchuserbyusername")
    public String searchByUserName(@RequestParam String searchText, Model model) {
        model.addAttribute("lstUser", userService.getListUserByUserName(searchText));
        return "list-user";
    }

}
