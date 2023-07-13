package com.teachsync.services.applicationDetail;

import com.teachsync.dtos.applicationDetail.ApplicationDetailReadDTO;
import com.teachsync.entities.ApplicationDetail;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface ApplicationDetailService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    ApplicationDetailReadDTO wrapDTO(ApplicationDetail applicationDetail, Collection<DtoOption> options) throws Exception;
    List<ApplicationDetailReadDTO> wrapListDTO(Collection<ApplicationDetail> applicationDetailCollection, Collection<DtoOption> options) throws Exception;
    Page<ApplicationDetailReadDTO> wrapPageDTO(Page<ApplicationDetail> applicationDetailPage, Collection<DtoOption> options) throws Exception;
}
