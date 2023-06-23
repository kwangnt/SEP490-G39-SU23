package com.teachsync.controllers;

import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.entities.Course;
import com.teachsync.services.course.CourseService;
import com.teachsync.utils.MiscUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private MiscUtil miscUtil;

    @GetMapping("/course")
    public String course(Model model) {
        try {
            /* Hot course */
            Page<CourseReadDTO> dtoPage = courseService.getPageDTOAllHotCourse(null);
            if (dtoPage != null) {
                model.addAttribute("hotCourseList", dtoPage.getContent());
                model.addAttribute("hotPageNo", dtoPage.getPageable().getPageNumber());
                model.addAttribute("hotPageTotal", dtoPage.getTotalPages());
            }

            /* All course */
            dtoPage = courseService.getPageDTOAll(null);
            if (dtoPage != null) {
                model.addAttribute("courseList", dtoPage.getContent());
                model.addAttribute("pageNo", dtoPage.getPageable().getPageNumber());
                model.addAttribute("pageTotal", dtoPage.getTotalPages());
            }

            /* TODO: set up searchable course */
            model.addAttribute(
                    "searchableFieldList",
                    miscUtil.sortSearchableField(Course.class.getDeclaredFields()));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
        }

        return "list-course";
    }

    @GetMapping("/course-detail")
    public String getDetailById(
            @RequestParam Long id,
            Model model) {
        try {
            CourseReadDTO course = courseService.getDTOById(id);

            if (course == null) {
                /* Not found by Id */
                return "redirect:/course";
            }

            model.addAttribute("course", course);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
        }

        return "course-detail";
    }

    @GetMapping("/enroll")
    public String enroll(@RequestParam Long id) {

        return "enroll";
    }

}
