package com.teachsync.services.course;

import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.dtos.priceLog.PriceLogReadDTO;
import com.teachsync.entities.Course;
import com.teachsync.entities.PriceLog;
import com.teachsync.repositories.CourseRepository;
import com.teachsync.repositories.PriceLogRepository;
import com.teachsync.services.priceLog.PriceLogService;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PriceLogService priceLogService;

    @Autowired
    private PriceLogRepository priceLogRepository;

    @Autowired
    private MiscUtil miscUtil;
    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */
    @Override
    @Transactional
    public CourseReadDTO addCourse(CourseReadDTO courseReadDTO, Long userId) throws Exception {
        Course course = new Course();

        course.setCourseName(courseReadDTO.getCourseName());
        //TODO : process upload file
        course.setCourseImg(courseReadDTO.getCourseImg());
        course.setCourseDesc(courseReadDTO.getCourseDesc());
        course.setMinScore(courseReadDTO.getMinScore());
        course.setMinAttendant(courseReadDTO.getMinAttendant());
        course.setStatus(Status.CREATED);
        course.setCreatedBy(userId);
        course.setUpdatedBy(userId);
        Course courseDb = courseRepository.save(course);
        if (ObjectUtils.isEmpty(courseDb)) {
            throw new Exception("Tạo khóa học thất bại");
        }

        //add price
        PriceLog priceLog = new PriceLog();
        priceLog.setCourseId(courseDb.getId());
        priceLog.setPrice(courseReadDTO.getCurrentPrice().getPrice());
        priceLog.setStatus(Status.CREATED);
        priceLog.setIsCurrent(true);
        priceLog.setIsPromotion(false);
        priceLog.setValidFrom(LocalDateTime.now());
        priceLog.setValidTo(LocalDateTime.now());
        priceLog.setCreatedBy(userId);
        priceLog.setUpdatedBy(userId);

        PriceLog priceLogDb = priceLogRepository.save(priceLog);
        if (ObjectUtils.isEmpty(priceLogDb)) {
            throw new Exception("Tạo giá của khóa học thất bại");
        }
        return mapper.map(courseDb, CourseReadDTO.class);
    }

    /* =================================================== READ ===================================================== */
    @Override
    public Page<Course> getPageAll(Pageable paging) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging();
        }

        Page<Course> coursePage =
                courseRepository.findAllByStatusNot(Status.DELETED, paging);

        if (coursePage.isEmpty()) {
            return null;
        }

        return coursePage;
    }

    @Override
    public Page<CourseReadDTO> getPageDTOAll(Pageable paging) throws Exception {
        Page<Course> coursePage = getPageAll(paging);

        if (coursePage == null) {
            return null;
        }

        return wrapPageDTO(coursePage);
    }
    @Override
    public Page<CourseReadDTO> getPageDTOAllHotCourse(Pageable paging) throws Exception {
        Page<PriceLogReadDTO> priceLogDTOPage = priceLogService.getPageAllLatestPromotionDTO(paging);

        if (priceLogDTOPage == null) {
            return null; }

        Map<Long, PriceLogReadDTO> courseIdPriceLogDTOMap =
                priceLogDTOPage.stream()
                        .collect(Collectors.toMap(PriceLogReadDTO::getCourseId, Function.identity()));

        Page<Course> coursePage = getPageAllByIdIn(priceLogDTOPage.getPageable(), courseIdPriceLogDTOMap.keySet());

        if (coursePage == null) {
            return null; }

        List<CourseReadDTO> courseDTOList = wrapListDTO(coursePage.getContent());

        courseDTOList =
                courseDTOList.stream()
                        .peek(dto -> dto.setCurrentPrice(courseIdPriceLogDTOMap.get(dto.getId())))
                        .collect(Collectors.toList());

        return new PageImpl<>(
                courseDTOList,
                coursePage.getPageable(),
                coursePage.getTotalPages());
    }

    @Override
    public List<Course> getAll() throws Exception {
        List<Course> coursePage =
                courseRepository.findAllByStatusNot(Status.DELETED);

        if (coursePage.isEmpty()) {
            return null;
        }

        return coursePage;
    }

    @Override
    public List<CourseReadDTO> getAllDTO() throws Exception {
        List<Course> courseList = getAll();

        if (courseList == null) {
            return null;
        }

        return wrapListDTO(courseList);
    }

    /* id */
    @Override
    public Course getById(Long id) throws Exception {
        Optional<Course> course =
                courseRepository.findByIdAndStatusNot(id, Status.DELETED);

        return course.orElse(null);
    }

    @Override
    public CourseReadDTO getDTOById(Long id) throws Exception {
        Course course = getById(id);

        if (course == null) {
            return null;
        }

        return wrapDTO(course);
    }

    @Override
    public Page<Course> getPageAllByIdIn(Pageable paging, Collection<Long> courseIdCollection) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging(); }

        Page<Course> coursePage =
                courseRepository.findAllByIdInAndStatusNot(courseIdCollection, Status.DELETED, paging);

        if (coursePage.isEmpty()) {
            return null; }

        return coursePage;
    }
    @Override
    public Page<CourseReadDTO> getPageDTOAllByIdIn(Pageable paging, Collection<Long> courseIdCollection) throws Exception {
        Page<Course> coursePage = getPageAllByIdIn(paging, courseIdCollection);

        if (coursePage == null) {
            return null; }

        return wrapPageDTO(coursePage);
    }

    /* =================================================== UPDATE =================================================== */



    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public CourseReadDTO wrapDTO(Course course) throws Exception {
        CourseReadDTO dto = mapper.map(course, CourseReadDTO.class);

        /* Add Dependency */
        /* TODO: replace with dto and call service */
        PriceLogReadDTO priceLogDTO =
                priceLogService.getLatestDTOByCourseId(course.getId());

        dto.setCurrentPrice(priceLogDTO);

//        dto.setMaterialList();
//        dto.setClassroomList();

        return dto;
    }

    @Override
    public List<CourseReadDTO> wrapListDTO(Collection<Course> courseCollection) throws Exception {
        List<CourseReadDTO> dtoList = new ArrayList<>();

        CourseReadDTO dto;

        for (Course course : courseCollection) {
            dto = mapper.map(course, CourseReadDTO.class);

            /* Add Dependency */
//            dto.setPriceLogList();
//            dto.setMaterialList();
//            dto.setClassroomList();

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<CourseReadDTO> wrapPageDTO(Page<Course> coursePage) throws Exception {
        return new PageImpl<>(
                wrapListDTO(coursePage.getContent()),
                coursePage.getPageable(),
                coursePage.getTotalPages());
    }
}
