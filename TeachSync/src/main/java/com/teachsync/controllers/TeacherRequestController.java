package com.teachsync.controllers;

import com.teachsync.dtos.request.RequestCreateDTO;
import com.teachsync.dtos.request.RequestReadDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.services.teacherRequest.TeacherRequestService;
import com.teachsync.utils.Constants;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/teacher-request")
public class TeacherRequestController {

    @Autowired
    TeacherRequestService teacherRequestService;

    private Logger logger = LoggerFactory.getLogger(TeacherRequestController.class);

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

    @GetMapping("/list")
    public String listTeacherRequest(Model model, @ModelAttribute("mess") String mess, HttpServletRequest request, RedirectAttributes redirect) throws Exception {
        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }
        UserReadDTO userDto = (UserReadDTO) session.getAttribute("user");
        if(!userDto.getRoleId().equals(Constants.ROLE_ADMIN)){
            redirect.addAttribute("mess", "bạn không đủ quyền");
            return "redirect:/";
        }
        Page<RequestReadDTO> dtoPage = teacherRequestService.getPageAll(null);
        if (dtoPage != null) {
            model.addAttribute("teacherQuestList", dtoPage.getContent());
            model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
            model.addAttribute("pageTotal", dtoPage.getTotalPages());

        }
        model.addAttribute("mess", mess);

        return "list-teacher-request";
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
        //TODO :Check role admin
        if(!userDTO.getRoleId().equals(Constants.ROLE_STUDENT)){
            redirect.addAttribute("mess", "Tính năng không hợp lệ");
            return "redirect:/";
        }

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

    @GetMapping("/change-status")
    public String changeStatusRequest(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }
        UserReadDTO userDto = (UserReadDTO) session.getAttribute("user");
        //TODO :Check role admin
        if(!userDto.getRoleId().equals(Constants.ROLE_ADMIN)){
            redirect.addAttribute("mess", "bạn không đủ quyền");
            return "redirect:/";
        }

        String operation = request.getParameter("operation");
        Long Id = Long.parseLong(request.getParameter("id"));
        String mess = "";
        if (operation.equals("approve")) {
            mess = "Chấp nhận";
        } else {
            mess = "Từ chối";
        }
        try {
            teacherRequestService.changeStatus(Id, operation);
        } catch (Exception e) {
            logger.error(e.getMessage());
            redirect.addAttribute("mess", mess + " thất bại ,lỗi : " +e.getMessage());
            return "redirect:/teacher-request/list";

        }
        redirect.addAttribute("mess", mess + " yêu cầu tuyển dụng giáo viên thành công");
        return "redirect:/teacher-request/list";
    }

}
