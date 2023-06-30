package com.teachsync.services.Material;

import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.entities.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface MaterialService {
    Page<Material> getPageAll(Pageable paging) throws Exception;
    Page<MaterialReadDTO> getPageDTOAll(Pageable paging) throws Exception;

    Material getById(Long id) throws Exception;
    MaterialReadDTO getDTOById(Long id) throws Exception;



    /* =================================================== WRAPPER ================================================== */
    MaterialReadDTO wrapDTO(Material material) throws Exception;

    List<MaterialReadDTO> wrapListDTO(Collection<Material> materialsCollection) throws Exception;

    Page<MaterialReadDTO> wrapPageDTO(Page<Material> newsPage) throws Exception;
}
