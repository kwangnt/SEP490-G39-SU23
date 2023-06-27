package com.teachsync.services.clazzSchedule;

import com.teachsync.dtos.clazzSchedule.ClazzScheduleReadDTO;
import com.teachsync.entities.ClazzSchedule;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ClazzScheduleService {
    /* =================================================== CREATE =================================================== */
    
    
    /* =================================================== READ ===================================================== */
    /* clazzId */
    ClazzSchedule getByClazzId(Long clazzId) throws Exception;
    ClazzScheduleReadDTO getDTOByClazzId(Long clazzId, Collection<DtoOption> options) throws Exception;

    /* clazzId */
    List<ClazzSchedule> getAllByClazzIdIn(Collection<Long> clazzIdCollection) throws Exception;
    List<ClazzScheduleReadDTO> getAllDTOByClazzIdIn(
            Collection<Long> clazzIdCollection, Collection<DtoOption> options) throws Exception;
    Map<Long, ClazzScheduleReadDTO> mapClazzIdDTOByClazzIdIn(
            Collection<Long> clazzIdCollection, Collection<DtoOption> options) throws Exception;

    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    ClazzScheduleReadDTO wrapDTO(ClazzSchedule clazzSchedule, Collection<DtoOption> options) throws Exception;

    List<ClazzScheduleReadDTO> wrapListDTO(
            Collection<ClazzSchedule> clazzScheduleCollection, Collection<DtoOption> options) throws Exception;

    Page<ClazzScheduleReadDTO> wrapPageDTO(
            Page<ClazzSchedule> clazzSchedulePage, Collection<DtoOption> options) throws Exception;
}
