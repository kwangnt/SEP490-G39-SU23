package com.teachsync.controllers;

import com.teachsync.dtos.clazz.ClazzCreateDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzUpdateDTO;
import com.teachsync.services.clazz.ClazzService;
import com.teachsync.services.course.CourseService;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @Autowired
    CourseService courseService;

    @Autowired
    private ModelMapper mapper;



    @GetMapping("/clazz")
    public String home(Model model, @ModelAttribute("mess") String mess) throws Exception {
        try {
            Page<ClazzReadDTO> dtoPage = clazzService.getPageDTOAll(null);

            if (dtoPage != null) {
                model.addAttribute("clazzList", dtoPage.getContent());
                model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
                model.addAttribute("pageTotal", dtoPage.getTotalPages());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("mess", mess);
        return "list-clazz";
    }

    @GetMapping("/add-clazz")
    public String addClazz(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute("listCourse", courseService.getAllDTO());
        if (!ObjectUtils.isEmpty(request.getParameter("Id"))) {
            model.addAttribute("clazz", clazzService.getDTOById(Long.parseLong(request.getParameter("Id"))));
        }
        model.addAttribute("option", request.getParameter("option"));

        return "add-clazz";
    }

    @PostMapping("/add-clazz")
    public String addClazz(
            HttpServletRequest request,
            Model model,
            RedirectAttributes redirect) throws Exception {
        ClazzCreateDTO createDTO = new ClazzCreateDTO();
        createDTO.setClazzName(request.getParameter("name"));
        createDTO.setClazzDesc(request.getParameter("desc"));
        createDTO.setCourseId(Long.parseLong(request.getParameter("courseId")));

        String result = "";
        String optional = "";

        if (ObjectUtils.isEmpty(request.getParameter("clazzId"))) {
            result = clazzService.addClazz(createDTO);
            optional = "Thêm mới";
        } else {
            ClazzUpdateDTO updateDTO = mapper.map(createDTO, ClazzUpdateDTO.class);

            updateDTO.setStatus(Status.UPDATED);
            updateDTO.setId(Long.parseLong(request.getParameter("clazzId")));

            result = clazzService.editClazz(updateDTO);
            optional = "Sửa";
        }

        if (result.equals("success")) {
            redirect.addAttribute("mess", optional + " class room thành công");
            return "redirect:/clazz";
        } else {
            model.addAttribute("mess", optional + " class room thất bại");
            return "add-clazz";
        }
    }

    @GetMapping("/delete-clazz")
    public String deleteClazz(HttpServletRequest request, Model model, RedirectAttributes redirect) {
        Long Id = Long.parseLong(request.getParameter("Id"));
        String result = clazzService.deleteClazz(Id);
        if (result.equals("success")) {
            redirect.addAttribute("mess", "Xóa class room thành công");
            return "redirect:/clazz";
        } else {
            model.addAttribute("mess", "Xóa class room thất bại");
            return "add-clazz";
        }
    }
}
