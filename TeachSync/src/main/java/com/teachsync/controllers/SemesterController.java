package com.teachsync.controllers;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.dtos.courseSemester.CourseSemesterReadDTO;
import com.teachsync.dtos.semester.SemesterReadDTO;
import com.teachsync.dtos.user.UserReadDTO;
import com.teachsync.entities.CourseSemester;
import com.teachsync.services.center.CenterService;
import com.teachsync.services.course.CourseService;
import com.teachsync.services.courseSemester.CourseSemesterService;
import com.teachsync.services.semester.SemesterService;
import com.teachsync.utils.Constants;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.DtoOption;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class SemesterController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseSemesterService courseSemesterService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private CenterService centerService;
    
    @Autowired
    private MiscUtil miscUtil;
    
    

    @GetMapping("/semester")
    public String getSemester(
            HttpSession session,
            Model model,
            @ModelAttribute("mess") String mess,
            @RequestParam(value = "pageNo", required = false) Integer pageNo,
            @SessionAttribute(name = "user", required = false) UserReadDTO userDTO) {
        model.addAttribute("mess", mess);
        
        if (userDTO == null || !userDTO.getRoleId().equals(Constants.ROLE_ADMIN)) {
            /* Không phải admin, đá ra ngoài */
            /* TODO: notification */
            return "redirect:/index";
        }
        
        try {
            Map<Long, CourseReadDTO> courseIdCourseDTOMap = courseService.mapIdDTO(null);
            model.addAttribute("courseIdCourseDTOMap", courseIdCourseDTOMap);

            Map<Long, CenterReadDTO> centerIdCenterDTOMap = centerService.mapIdDTO(null);
            model.addAttribute("centerIdCenterDTOMap", centerIdCenterDTOMap);

            if (pageNo == null) { pageNo = 0; }
            Pageable paging = miscUtil.makePaging(pageNo, 10, "startDate", false);

            Page<SemesterReadDTO> semesterDTOPage = semesterService.getPageDTOAll(paging, null);

            if (semesterDTOPage == null) {
                return "list-semester";
            }

            Map<Long, SemesterReadDTO> semesterIdSemesterDTOMap =
                    semesterDTOPage.getContent().stream()
                            .collect(Collectors.toMap(BaseReadDTO::getId, Function.identity()));

            Map<Long, Map<Long, Set<Long>>> semesterIdCenterIdCourseIdSetMapMap =
                    courseSemesterService.mapSemesterIdMapCenterIdListCourseIdBySemesterIdIn(semesterIdSemesterDTOMap.keySet());

            model.addAttribute("semesterIdSemesterDTOMap", semesterIdSemesterDTOMap);

            model.addAttribute("pageNo", semesterDTOPage.getPageable().getPageNumber());
            model.addAttribute("pageTotal", semesterDTOPage.getTotalPages());

            model.addAttribute("distributionMap", semesterIdCenterIdCourseIdSetMapMap);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        return "list-semester";
    }

}
