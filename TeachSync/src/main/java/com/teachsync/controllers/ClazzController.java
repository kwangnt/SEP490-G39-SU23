package com.teachsync.controllers;

import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.services.clazz.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @GetMapping("/classroom")
    public String home(Model model) throws Exception {
        try {
            Page<ClazzReadDTO> dtoPage = clazzService.getPageDTOAll(null);

            if (dtoPage != null) {
                model.addAttribute("classroomList", dtoPage.getContent());
                model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
                model.addAttribute("pageTotal", dtoPage.getTotalPages());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "list-classroom";
    }
}
