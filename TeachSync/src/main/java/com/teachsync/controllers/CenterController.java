package com.teachsync.controllers;

import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.Center;
import com.teachsync.entities.Course;
import com.teachsync.repositories.CenterRepository;
import com.teachsync.services.center.CenterService;
import com.teachsync.utils.Constants;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CenterController {
    @Autowired
    private CenterRepository centerRepository;


    @GetMapping("/center")
    public String center(Model model, HttpSession session){
        return "list-center";
    }

    @GetMapping("/room")
    public String room(){
        return "list-room";
    }

    @GetMapping("/center-detail")
    public String centerDetail(){
        return "center-detail";
    }

}
