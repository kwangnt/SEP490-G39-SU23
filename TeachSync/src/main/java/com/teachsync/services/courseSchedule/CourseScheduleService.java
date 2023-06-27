package com.teachsync.services.courseSchedule;

import com.teachsync.dtos.courseSchedule.CourseScheduleCreateDTO;
import com.teachsync.dtos.courseSchedule.CourseScheduleReadDTO;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CourseScheduleService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */
    /* id */
    CourseSchedule getById(Long id) throws Exception;
    CourseScheduleReadDTO getDTOById(Long id, Collection<DtoOption> options) throws Exception;

    List<CourseSchedule> getAllByIdIn(Collection<Long> idCollection) throws Exception;
    List<CourseScheduleReadDTO> getAllDTOByIdIn(
            Collection<Long> idCollection, Collection<DtoOption> options) throws Exception;
    Map<Long, CourseScheduleReadDTO> mapScheduleIdDTOByIdIn(
            Collection<Long> idCollection, Collection<DtoOption> options) throws Exception;

    /* courseId */
    List<CourseSchedule> getAllByCourseId(Long courseId) throws Exception;
    List<CourseScheduleReadDTO> getAllDTOByCourseId(
            Long courseId, Collection<DtoOption> options) throws Exception;

    List<CourseSchedule> getAllLatestByCourseId(Long courseId) throws Exception;
    List<CourseScheduleReadDTO> getAllLatestDTOByCourseId(
            Long courseId, Collection<DtoOption> options) throws Exception;
    Map<Long, CourseScheduleReadDTO> mapScheduleIdLatestDTOByCourseId(
            Long courseId, Collection<DtoOption> options) throws Exception;


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    CourseScheduleReadDTO wrapDTO(
            CourseSchedule courseSchedule, Collection<DtoOption> options) throws Exception;
    List<CourseScheduleReadDTO> wrapListDTO(
            Collection<CourseSchedule> courseScheduleCollection, Collection<DtoOption> options) throws Exception;
    Page<CourseScheduleReadDTO> wrapPageDTO(
            Page<CourseSchedule> courseSchedulePage, Collection<DtoOption> options) throws Exception;
}
