package com.teachsync.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
//    @Autowired
//    private CourseService courseService;

    @GetMapping("/course")
    public String course(Model model) {
        /* TODO: get course list, hot course list */

        return "list-course";
    }

    @GetMapping("/course-detail")
    public String getDetailById(
            @RequestParam Long id,
            Model model) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "list-course";
    }
}
