package com.teachsync.controllers;

import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.dtos.courseSchedule.CourseScheduleReadDTO;
import com.teachsync.dtos.request.RequestCreateDTO;
import com.teachsync.dtos.request.RequestReadDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.services.clazz.ClazzService;
import com.teachsync.services.course.CourseService;
import com.teachsync.services.courseSchedule.CourseScheduleService;
import com.teachsync.services.teacherRequest.TeacherRequestService;
import com.teachsync.utils.Constants;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.DtoOption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EnrollController {
    @Autowired
    private TeacherRequestService teacherRequestService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseScheduleService courseScheduleService;
    @Autowired
    private ClazzService clazzService;

    @Autowired
    private MiscUtil miscUtil;



//    @PreAuthorize("hasAuthority(T(com.teachsync.utils.Constants).ROLE_STUDENT)")
    @GetMapping("/enroll")
    public String enroll(
            HttpServletRequest request,
            @RequestParam(name = "id") Long courseId,
            Model model,
            @SessionAttribute(name = "user", required = false) UserReadDTO userDTO) {
        if (userDTO == null) {
            return "redirect:/course";
        }
        if (!userDTO.getRoleId().equals(Constants.ROLE_STUDENT)) {
            /* Quay về trang cũ */
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }

        try {
            CourseReadDTO courseDTO =  courseService.getDTOById(courseId);

            Map<Long, CourseScheduleReadDTO> scheduleIdLatestDTOMap =
                    courseScheduleService.mapScheduleIdLatestDTOByCourseId(
                            courseId,
                            List.of(DtoOption.CENTER_NAME));

            Map<Long, List<ClazzReadDTO>> scheduleIdClazzDTOListMap =
                    clazzService.mapScheduleIdClazzDTOListByCourseScheduleIdIn(
                            scheduleIdLatestDTOMap.keySet(),
                            Arrays.asList(DtoOption.CLAZZ_SCHEDULE, DtoOption.MEMBER_LIST_STUDENT, DtoOption.ROOM_NAME));

            Map<CourseScheduleReadDTO, List<ClazzReadDTO>> scheduleClazzListMap = new HashMap<>();

            for (Long scheduleId : scheduleIdLatestDTOMap.keySet()) {
                scheduleClazzListMap.put(
                        scheduleIdLatestDTOMap.get(scheduleId),
                        scheduleIdClazzDTOListMap.get(scheduleId));
            }

            model.addAttribute("course", courseDTO);
            model.addAttribute("scheduleClazzListMap", scheduleClazzListMap);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
        }

        return "enroll";
    }


    @PostMapping("/enroll")
    public String enroll(
            Model model,
            @RequestParam Long clazzId,
            @SessionAttribute(name = "user", required = false) UserReadDTO userDTO) {

        return "redirect:/index";
//        TODO:
//        try {
//            RequestCreateDTO createDTO = new RequestCreateDTO();
//
//            createDTO.setRequesterId(userDTO.getId());
//            createDTO.setClazzId(clazzId);
//
//            createDTO.setRequestType("ENROLL");
//
//            createDTO.setRequestName(userDTO.getFullName() + "đăng ký lớp: " + clazzId);
//
//            createDTO.setRequestDesc(userDTO.getFullName() + "đăng ký lớp: " + clazzId);
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "request-detail";
    }
}
