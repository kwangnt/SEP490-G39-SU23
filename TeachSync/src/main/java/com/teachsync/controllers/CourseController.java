package com.teachsync.controllers;

import com.teachsync.dtos.course.CourseCreateDTO;
import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.Course;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.services.course.CourseService;
import com.teachsync.services.courseSchedule.CourseScheduleService;
import com.teachsync.utils.MiscUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.teachsync.utils.Constants.ROLE_ADMIN;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseScheduleService courseScheduleService;

    @Autowired
    private MiscUtil miscUtil;

    @GetMapping("/course")
    public String course(Model model, @ModelAttribute("mess") String mess) {
        /* TODO: get course list, hot course list */

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
        model.addAttribute("mess", mess);

        return "list-course";
    }

    @GetMapping("/course-detail")
    public String getDetailById(
            @RequestParam(name = "id") Long courseId,
            Model model) {
        try {
            CourseReadDTO course = courseService.getDTOById(courseId);

            if (course == null) {
                /* Not found by Id */
                return "redirect:/course";
            }

            List<CourseSchedule> courseScheduleList =
                    courseScheduleService.getAllLatestByCourseId(courseId);

            model.addAttribute("course", course);
            model.addAttribute(
                    "hasLatestSchedule",
                    (courseScheduleList != null && !courseScheduleList.isEmpty()));

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Server error, please try again later");
        }

        return "course-detail";
    }

    @GetMapping("/add-course")
    public String addCourse(HttpServletRequest request, RedirectAttributes redirect) {
        HttpSession session = request.getSession();

        UserReadDTO userDTO = (UserReadDTO) session.getAttribute("user");

        if (ObjectUtils.isEmpty(userDTO)) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }

        if (!userDTO.getRoleId().equals(ROLE_ADMIN)) {
            redirect.addAttribute("mess", "Bạn không đủ quyền");
            return "redirect:/";
        }

        return "add-course";
    }

    @PostMapping("/add-course")
    public String addCourse(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        HttpSession session = request.getSession();
        if (ObjectUtils.isEmpty(session.getAttribute("user"))) {
            redirect.addAttribute("mess", "Làm ơn đăng nhập");
            return "redirect:/";
        }
        UserReadDTO userDTO = (UserReadDTO) session.getAttribute("user");
        if (!userDTO.getRoleId().equals(ROLE_ADMIN)) {
            redirect.addAttribute("mess", "Bạn không đủ quyền");
            return "redirect:/";
        }


        /* Thay = modelAttr or json (RequestBody) */
        CourseCreateDTO courseDTO = new CourseCreateDTO();
        courseDTO.setCourseName(request.getParameter("name"));
        //TODO : process upload file
        courseDTO.setCourseImg("https://th.bing.com/th/id/OIP.R7Wj-CVruj2Gcx-MmaxmZAHaKe?pid=ImgDet&rs=1");
        courseDTO.setCourseDesc(request.getParameter("desc"));
        courseDTO.setMinScore(Double.parseDouble(request.getParameter("score")));
        courseDTO.setMinAttendant(Double.parseDouble(request.getParameter("attendant")));
        courseDTO.setPrice(Double.parseDouble(request.getParameter("price")));

        try {
            courseService.addCourse(courseDTO, userDTO.getId());
        } catch (Exception e) {
            model.addAttribute("mess", "Lỗi : " + e.getMessage());
            return "add-course";
        }

        redirect.addAttribute("mess", "Tạo mới khóa học thành công");
        return "redirect:/course";
    }
}
