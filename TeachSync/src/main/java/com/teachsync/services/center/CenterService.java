package com.teachsync.services.center;

import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.entities.Center;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface CenterService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */
    /* id */
    Center getById(Long id) throws Exception;

    List<Center> getAllByIdIn(Collection<Long> idCollection) throws Exception;
    Map<Long, String> mapCenterIdCenterNameByIdIn(Collection<Long> idCollection) throws Exception;

    
    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */
    
    
    /* =================================================== WRAPPER ================================================== */
    CenterReadDTO wrapDTO(Center center, Collection<DtoOption> options) throws Exception;
    List<CenterReadDTO> wrapListDTO(Collection<Center> centerCollection, Collection<DtoOption> options) throws Exception;
    Page<CenterReadDTO> wrapPageDTO(Page<Center> centerPage, Collection<DtoOption> options) throws Exception;
}
