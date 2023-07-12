package com.teachsync.controllers;

import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.services.center.CenterService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CenterController {
    @Autowired
    private CenterService centerService;


    @GetMapping("/center")
    public String center(Model model, HttpSession session) {
        try{
            List<CenterReadDTO> list = centerService.getAllDTO(null);
            model.addAttribute("listCenter",list);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "list-center";
    }

    @GetMapping("/room")
    public String room(){
        return "list-room";
    }

    @GetMapping("/center-detail")
    public String centerDetail(){
//        try{
//            CenterReadDTO center = centerService.getDTOById(centerId,null);
//            model.addAttribute("center", center);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return "center-detail";
    }

}
