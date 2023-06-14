package com.teachsync.controllers;

import com.teachsync.dtos.classroom.ClassroomDto;
import com.teachsync.services.classroom.ClassroomService;
import com.teachsync.services.course.CourseService;
import com.teachsync.utils.enums.Status;
import jakarta.servlet.http.HttpServletRequest;
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
public class ClassRoomController {

    @Autowired
    ClassroomService classroomService;

    @Autowired
    CourseService courseService;

    @GetMapping("/classroom")
    public String getListClassroom(Model model, @ModelAttribute("mess") String mess) throws Exception {
        Page<ClassroomDto> dtoPage = classroomService.getPageAll(null);

        if (dtoPage != null) {
            model.addAttribute("classroomList", dtoPage.getContent());
            model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
            model.addAttribute("pageTotal", dtoPage.getTotalPages());

        }
        model.addAttribute("mess", mess);
        return "list-classroom";
    }

    @GetMapping("/add-classroom")
    public String addClassroom(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute("listCourse", courseService.getListCourseReadDTO());
        if (!ObjectUtils.isEmpty(request.getParameter("Id"))) {
            model.addAttribute("classroom", classroomService.findById(Long.parseLong(request.getParameter("Id"))));
        }
        model.addAttribute("option", request.getParameter("option"));

        return "add-classroom";
    }

    @PostMapping("/add-classroom")
    public String addClassroom(HttpServletRequest request, Model model, RedirectAttributes redirect) throws Exception {
        ClassroomDto classroomDto = new ClassroomDto();
        classroomDto.setClassName(request.getParameter("name"));
        classroomDto.setClassDesc(request.getParameter("desc"));
        classroomDto.setCourseId(Long.parseLong(request.getParameter("courseId")));
        String result = "";
        String optional = "";
        if (ObjectUtils.isEmpty(request.getParameter("classroomId"))) {
            result = classroomService.addClassroom(classroomDto);
            optional = "Thêm mới";
        } else {
            classroomDto.setId(Long.parseLong(request.getParameter("classroomId")));
            result = classroomService.editClassroom(classroomDto);
            optional = "Sửa";
        }


        if (result.equals("success")) {
            redirect.addAttribute("mess", optional + " class room thành công");
            return "redirect:/classroom";
        } else {
            model.addAttribute("mess", optional + " class room thất bại");
            return "add-classroom";
        }
    }

    @GetMapping("/delete-classroom")
    public String deleteClassroom(HttpServletRequest request, Model model, RedirectAttributes redirect) {
        Long Id = Long.parseLong(request.getParameter("Id"));
        String result = classroomService.deleteClassroom(Id);
        if (result.equals("success")) {
            redirect.addAttribute("mess", "Xóa class room thành công");
            return "redirect:/classroom";
        } else {
            model.addAttribute("mess", "Xóa class room thất bại");
            return "add-classroom";
        }
    }
}
