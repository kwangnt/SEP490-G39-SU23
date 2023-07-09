package com.teachsync.services.clazz;

import com.teachsync.dtos.clazz.ClazzCreateDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzUpdateDTO;
import com.teachsync.entities.Clazz;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface ClazzService {
    /* =================================================== CREATE =================================================== */
    String addClazz(ClazzCreateDTO createDTO);


    /* =================================================== READ ===================================================== */
    Page<Clazz> getPageAll(Pageable paging) throws Exception;
    Page<ClazzReadDTO> getPageDTOAll(Pageable paging) throws Exception;

    /* id */
    Clazz getById(Long id) throws Exception;
    ClazzReadDTO getDTOById(Long id) throws Exception;

    List<Clazz> getAllByIdIn(Collection<Long> idCollection) throws Exception;
    Map<Long, String> mapClazzIdClazzNameByIdIn(Collection<Long> idCollection) throws Exception;

    /* courseSemesterId */
    List<Clazz> getAllByCourseSemesterIdIn(Collection<Long> scheduleIdCollection) throws Exception;
    List<ClazzReadDTO> getAllDTOByCourseSemesterIdIn(
            Collection<Long> scheduleIdCollection, Collection<DtoOption> options) throws Exception;
    Map<Long, List<ClazzReadDTO>> mapScheduleIdClazzDTOListByCourseSemesterIdIn(
            Collection<Long> scheduleIdCollection, Collection<DtoOption> options) throws Exception;


    /* =================================================== UPDATE =================================================== */
    String editClazz(ClazzUpdateDTO updateDTO);


    /* =================================================== DELETE =================================================== */
    String deleteClazz(Long Id);


    /* =================================================== WRAPPER ================================================== */
    ClazzReadDTO wrapDTO(Clazz clazz, Collection<DtoOption> options) throws Exception;
    List<ClazzReadDTO> wrapListDTO(Collection<Clazz> clazzCollection, Collection<DtoOption> options) throws Exception;
    Page<ClazzReadDTO> wrapPageDTO(Page<Clazz> clazzPage, Collection<DtoOption> options) throws Exception;
}
