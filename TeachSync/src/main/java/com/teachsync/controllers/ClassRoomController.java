package com.teachsync.controllers;

import com.teachsync.dtos.classroom.ClassroomDto;
import com.teachsync.services.classroom.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassRoomController {

    @Autowired
    ClassroomService classroomService;

    @GetMapping("/classroom")
    public String home(Model model) throws Exception {
        Page<ClassroomDto> dtoPage = classroomService.getPageAll(null);

        if (dtoPage != null) {
            model.addAttribute("classroomList", dtoPage.getContent());
            model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
            model.addAttribute("pageTotal", dtoPage.getTotalPages());

        }
        return "list-classroom";
    }

}
