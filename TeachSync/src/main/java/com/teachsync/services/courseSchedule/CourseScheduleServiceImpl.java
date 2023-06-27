package com.teachsync.services.courseSchedule;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.courseSchedule.CourseScheduleCreateDTO;
import com.teachsync.dtos.courseSchedule.CourseScheduleReadDTO;
import com.teachsync.dtos.priceLog.PriceLogReadDTO;
import com.teachsync.entities.Center;
import com.teachsync.entities.Course;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.entities.PriceLog;
import com.teachsync.repositories.CourseScheduleRepository;
import com.teachsync.repositories.PriceLogRepository;
import com.teachsync.services.center.CenterService;
import com.teachsync.services.course.CourseService;
import com.teachsync.services.priceLog.PriceLogService;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.DtoOption;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {
    @Autowired
    private CourseScheduleRepository courseScheduleRepository;

    @Lazy
    @Autowired
    private CourseService courseService;
    @Lazy
    @Autowired
    private CenterService centerService;

    @Autowired
    private MiscUtil miscUtil;
    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */
    /* id */
    @Override
    public CourseSchedule getById(Long id) throws Exception {
        Optional<CourseSchedule> courseSchedule =
                courseScheduleRepository.findByIdAndStatusNot(id, Status.DELETED);

        return courseSchedule.orElse(null);
    }
    @Override
    public CourseScheduleReadDTO getDTOById(Long id, Collection<DtoOption> options) throws Exception {
        CourseSchedule courseSchedule = getById(id);

        if (courseSchedule == null) {
            return null;
        }

        return wrapDTO(courseSchedule, options);
    }

    @Override
    public List<CourseSchedule> getAllByIdIn(Collection<Long> idCollection) throws Exception {
        List<CourseSchedule> courseSchedulePage =
                courseScheduleRepository.findAllByIdInAndStatusNot(idCollection, Status.DELETED);

        if (courseSchedulePage.isEmpty()) {
            return null;
        }

        return courseSchedulePage;
    }
    @Override
    public List<CourseScheduleReadDTO> getAllDTOByIdIn(
            Collection<Long> idCollection, Collection<DtoOption> options) throws Exception {
        List<CourseSchedule> courseScheduleList = getAllByIdIn(idCollection);

        if (courseScheduleList == null) {
            return null;
        }

        return wrapListDTO(courseScheduleList, options);
    }
    @Override
    public Map<Long, CourseScheduleReadDTO> mapScheduleIdDTOByIdIn(
            Collection<Long> idCollection, Collection<DtoOption> options) throws Exception {
        List<CourseScheduleReadDTO> courseScheduleDTOList = getAllDTOByIdIn(idCollection, options);

        if (courseScheduleDTOList == null) {
            return new HashMap<>(); }

        return courseScheduleDTOList.stream()
                .collect(Collectors.toMap(BaseReadDTO::getId, Function.identity()));
    }

    /* courseId */
    @Override
    public List<CourseSchedule> getAllByCourseId(Long courseId) throws Exception {
        List<CourseSchedule> courseSchedulePage =
                courseScheduleRepository.findAllByCourseIdAndStatusNot(courseId, Status.DELETED);

        if (courseSchedulePage.isEmpty()) {
            return null;
        }

        return courseSchedulePage;
    }
    @Override
    public List<CourseScheduleReadDTO> getAllDTOByCourseId(
            Long courseId, Collection<DtoOption> options) throws Exception {
        List<CourseSchedule> courseScheduleList = getAllByCourseId(courseId);

        if (courseScheduleList == null) {
            return null;
        }

        return wrapListDTO(courseScheduleList, options);
    }

    @Override
    public List<CourseSchedule> getAllLatestByCourseId(
            Long courseId) throws Exception {
        List<CourseSchedule> courseSchedulePage =
                courseScheduleRepository.findAllByCourseIdAndStartDateAfterAndStatusNot(
                        courseId, LocalDate.now(), Status.DELETED);

        if (courseSchedulePage.isEmpty()) {
            return null;
        }

        return courseSchedulePage;
    }
    @Override
    public List<CourseScheduleReadDTO> getAllLatestDTOByCourseId(
            Long courseId, Collection<DtoOption> options) throws Exception {
        List<CourseSchedule> courseScheduleList = getAllLatestByCourseId(courseId);

        if (courseScheduleList == null) {
            return null;
        }

        return wrapListDTO(courseScheduleList, options);
    }
    @Override
    public Map<Long, CourseScheduleReadDTO> mapScheduleIdLatestDTOByCourseId(
            Long courseId, Collection<DtoOption> options) throws Exception {
        List<CourseScheduleReadDTO> latestDTOList = getAllLatestDTOByCourseId(courseId, options);

        if (latestDTOList == null) {
            return new HashMap<>();
        }

        return latestDTOList.stream()
                .collect(Collectors.toMap(BaseReadDTO::getId, Function.identity()));
    }


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public CourseScheduleReadDTO wrapDTO(
            CourseSchedule courseSchedule, Collection<DtoOption> options) throws Exception {
        CourseScheduleReadDTO dto = mapper.map(courseSchedule, CourseScheduleReadDTO.class);

        /* Add Dependency */
        if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.COURSE_NAME)) {
                Course course = courseService.getById(dto.getCourseId());
                dto.setCourseName(course.getCourseName());
            }

            if (options.contains(DtoOption.CENTER_NAME)) {
                Center center = centerService.getById(dto.getCenterId());
                dto.setCenterName(center.getCenterName());
            }
        }

        return dto;
    }
    @Override
    public List<CourseScheduleReadDTO> wrapListDTO(
            Collection<CourseSchedule> courseScheduleCollection, Collection<DtoOption> options) throws Exception {
        List<CourseScheduleReadDTO> dtoList = new ArrayList<>();

        CourseScheduleReadDTO dto;

        Map<Long, String> courseIdCourseNameMap = new HashMap<>();
        Map<Long, String> centerIdCenterNameMap = new HashMap<>();

        if (options != null && !options.isEmpty()) {
            Set<Long> courseIdSet = new HashSet<>();
            Set<Long> centerIdSet = new HashSet<>();

            for (CourseSchedule courseSchedule : courseScheduleCollection) {
                courseIdSet.add(courseSchedule.getCourseId());
                centerIdSet.add(courseSchedule.getCenterId());
            }

            if (options.contains(DtoOption.COURSE_NAME)) {
                courseIdCourseNameMap = courseService.mapCourseIdCourseNameByIdIn(courseIdSet);
            }

            if (options.contains(DtoOption.CENTER_NAME)) {
                centerIdCenterNameMap = centerService.mapCenterIdCenterNameByIdIn(centerIdSet);
            }
        }

        for (CourseSchedule courseSchedule : courseScheduleCollection) {
            dto = mapper.map(courseSchedule, CourseScheduleReadDTO.class);

            /* Add Dependency */
            dto.setCourseName(courseIdCourseNameMap.get(courseSchedule.getCourseId()));

            dto.setCenterName(centerIdCenterNameMap.get(courseSchedule.getCenterId()));

            dtoList.add(dto);
        }

        return dtoList;
    }
    @Override
    public Page<CourseScheduleReadDTO> wrapPageDTO(
            Page<CourseSchedule> courseSchedulePage, Collection<DtoOption> options) throws Exception {
        return new PageImpl<>(
                wrapListDTO(courseSchedulePage.getContent(), options),
                courseSchedulePage.getPageable(),
                courseSchedulePage.getTotalPages());
    }
}
