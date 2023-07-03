package com.teachsync.controllers;

import com.teachsync.dtos.homework.HomeworkReadDTO;
import com.teachsync.dtos.request.RequestReadDTO;
import com.teachsync.entities.Homework;
import com.teachsync.services.homework.HomeworkService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    private Logger logger = LoggerFactory.getLogger(HomeworkController.class);

    @Autowired
    HomeworkService homeworkService;

    @GetMapping("/list")
    public String viewTeacherRequest(HttpServletRequest request, RedirectAttributes redirect, Model model) {
        //check login
        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }

        try {
            Page<HomeworkReadDTO> dtoPage =  homeworkService.getPageAll(null);
            model.addAttribute("homeworkList", dtoPage.getContent());
            model.addAttribute("pageNo",dtoPage.isEmpty() ? 0 : dtoPage.getPageable().getPageNumber());
            model.addAttribute("pageTotal", dtoPage.getTotalPages());
        } catch (Exception e) {
            logger.error(e.getMessage());
            redirect.addAttribute("mess", "hiển thị danh sách bài tập về nhà thất bại ,lỗi : " +e.getMessage());
            return "redirect:/";

        }

        return "homework";
    }
}
