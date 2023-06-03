package com.teachsync.controllers;

import com.teachsync.entities.Course;
import com.teachsync.services.course.CourseService;
import com.teachsync.utils.MiscUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private MiscUtil miscUtil;

    @GetMapping("/course")
    public String course(Model model) {
        /* TODO: get course list, hot course list */

        try {
            Page<Course> coursePage = courseService.getPageAll(null);

            if (coursePage != null) {
                model.addAttribute("courseList", coursePage.getContent());
                model.addAttribute("pageNo", coursePage.getPageable().getPageNumber());
                model.addAttribute("pageTotal", coursePage.getTotalPages());

            }

            model.addAttribute(
                    "sortableFieldList",
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
            Course course = courseService.getById(id);

            if (course == null) {
                return "redirect:/course";
            }

            model.addAttribute("course", course);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
        }

        return "course-detail";
    }
}
