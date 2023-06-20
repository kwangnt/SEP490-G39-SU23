package com.teachsync.services.clazz;

import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.entities.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;


public interface ClazzService {
    /* =================================================== CREATE =================================================== */



    /* =================================================== READ ===================================================== */
    Page<Clazz> getPageAll(Pageable paging) throws Exception;
    Page<ClazzReadDTO> getPageDTOAll(Pageable paging) throws Exception;

    Clazz getById(Long id) throws Exception;
    ClazzReadDTO getDTOById(Long id) throws Exception;



    /* =================================================== UPDATE =================================================== */



    /* =================================================== DELETE =================================================== */



    /* =================================================== WRAPPER ================================================== */
    ClazzReadDTO wrapDTO(Clazz clazz) throws Exception;

    List<ClazzReadDTO> wrapListDTO(Collection<Clazz> clazzCollection) throws Exception;

    Page<ClazzReadDTO> wrapPageDTO(Page<Clazz> clazzPage) throws Exception;
}
