package com.teachsync.services.courseMaterial;

import com.teachsync.dtos.courseMaterial.CourseMaterialReadDTO;
import com.teachsync.entities.CourseMaterial;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface CourseMaterialService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    CourseMaterialReadDTO wrapDTO(CourseMaterial courseMaterial, Collection<DtoOption> options) throws Exception;
    List<CourseMaterialReadDTO> wrapListDTO(Collection<CourseMaterial> courseMaterialCollection, Collection<DtoOption> options) throws Exception;
    Page<CourseMaterialReadDTO> wrapPageDTO(Page<CourseMaterial> courseMaterialPage, Collection<DtoOption> options) throws Exception;
}
