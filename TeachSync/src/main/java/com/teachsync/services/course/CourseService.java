package com.teachsync.services.course;

import com.teachsync.dtos.course.CourseCreateDTO;
import com.teachsync.dtos.course.CourseReadDTO;
import com.teachsync.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CourseService {
    /* =================================================== CREATE =================================================== */
    CourseReadDTO addCourse(CourseCreateDTO courseDTO, Long userId) throws Exception;

    /* =================================================== READ ===================================================== */
    Page<Course> getPageAll(Pageable paging) throws Exception;

    Page<CourseReadDTO> getPageDTOAll(Pageable paging) throws Exception;
    Page<CourseReadDTO> getPageDTOAllHotCourse(Pageable paging) throws Exception;

    List<Course> getAll() throws Exception;

    List<CourseReadDTO> getAllDTO() throws Exception;

    /* id */
    Course getById(Long id) throws Exception;
    CourseReadDTO getDTOById(Long id) throws Exception;

    Page<Course> getPageAllByIdIn(Pageable paging, Collection<Long> courseIdCollection) throws Exception;
    Page<CourseReadDTO> getPageDTOAllByIdIn(Pageable paging, Collection<Long> courseIdCollection) throws Exception;

    List<Course> getAllByIdIn(Collection<Long> courseIdCollection) throws Exception;
    Map<Long, String> mapCourseIdCourseNameByIdIn(Collection<Long> courseIdCollection) throws Exception;


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    CourseReadDTO wrapDTO(Course course) throws Exception;

    List<CourseReadDTO> wrapListDTO(Collection<Course> courseCollection) throws Exception;

    Page<CourseReadDTO> wrapPageDTO(Page<Course> coursePage) throws Exception;
}
