package com.teachsync.services.clazz;

import com.teachsync.dtos.clazz.ClazzCreateDTO;
import com.teachsync.dtos.clazz.ClazzReadDTO;
import com.teachsync.dtos.clazz.ClazzUpdateDTO;
import com.teachsync.entities.Clazz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;


public interface ClazzService {
    /* =================================================== CREATE =================================================== */
    String addClazz(ClazzCreateDTO createDTO);


    /* =================================================== READ ===================================================== */
    Page<Clazz> getPageAll(Pageable paging) throws Exception;
    Page<ClazzReadDTO> getPageDTOAll(Pageable paging) throws Exception;

    Clazz getById(Long id) throws Exception;
    ClazzReadDTO getDTOById(Long id) throws Exception;



    /* =================================================== UPDATE =================================================== */
    String editClazz(ClazzUpdateDTO updateDTO);


    /* =================================================== DELETE =================================================== */
    String deleteClazz(Long Id);


    /* =================================================== WRAPPER ================================================== */
    ClazzReadDTO wrapDTO(Clazz clazz) throws Exception;

    List<ClazzReadDTO> wrapListDTO(Collection<Clazz> clazzCollection) throws Exception;

    Page<ClazzReadDTO> wrapPageDTO(Page<Clazz> clazzPage) throws Exception;
}
