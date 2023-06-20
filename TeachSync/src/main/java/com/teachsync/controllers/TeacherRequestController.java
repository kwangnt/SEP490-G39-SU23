package com.teachsync.controllers;

import com.teachsync.dtos.request.RequestCreateDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.services.teacherRequest.TeacherRequestService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/teacher-request")
public class TeacherRequestController {

    @Autowired
    TeacherRequestService teacherRequestService;

    @GetMapping("")
    public String viewTeacherRequest(HttpServletRequest request, RedirectAttributes redirect) {
        //check login
        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }

        return "teacher-request";
    }

    @PostMapping("/add")
    public String addTeacherRequest(
            HttpServletRequest request,
            HttpSession session,
            RedirectAttributes redirect) {
        //check login
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }
        UserReadDTO userDTO = (UserReadDTO) session.getAttribute("user");

        RequestCreateDTO createDTO = new RequestCreateDTO();

        createDTO.setRequesterId(userDTO.getId());
        createDTO.setRequestDesc(request.getParameter("requestDesc"));
        createDTO.setContentLink(request.getParameter("contentLink"));


        String result = teacherRequestService.addRequest(createDTO);

        if (result.equals("error")) {
            redirect.addAttribute("mess", "Lỗi khi thêm yêu cầu tuyển dụng giáo viên");
            return "teacher-request";
        }

        redirect.addAttribute("mess", "thêm yêu cầu tuyển dụng giáo viên thành công");
        return "redirect:/";
    }

}
