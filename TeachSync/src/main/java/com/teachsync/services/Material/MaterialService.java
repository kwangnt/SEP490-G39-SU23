package com.teachsync.services.Material;


import com.teachsync.dtos.material.MaterialCreateDTO;
import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.entities.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface MaterialService {
    MaterialReadDTO addMaterial(MaterialCreateDTO materialDTO, Long userId) throws Exception;

    /* =================================================== READ ===================================================== */
    Page<Material> getPageAll(Pageable paging) throws Exception;
    Page<MaterialReadDTO> getPageDTOAll(Pageable paging) throws Exception;

    List<Material> getAll() throws Exception;

    List<Material> getAllByIsFree() throws Exception;

    @Deprecated
    List<MaterialReadDTO> getAllDTO() throws Exception;

    /* id */
    Material getById(Long id) throws Exception;
    MaterialReadDTO getDTOById(Long id) throws Exception;

    Page<Material> getPageAllByIdIn(Pageable paging, Collection<Long> materialIdCollection) throws Exception;
    Page<MaterialReadDTO> getPageDTOAllByIdIn(Pageable paging, Collection<Long> materialIdCollection) throws Exception;

    List<Material> getAllByIdIn(Collection<Long> materialIdCollection) throws Exception;
    Map<Long, String> mapMaterialIdMaterialNameByIdIn(Collection<Long> materialIdCollection) throws Exception;



    /* =================================================== UPDATE =================================================== */

    MaterialReadDTO editMaterial(MaterialReadDTO materialReadDTO, Long userId) throws Exception;

    /* =================================================== DELETE =================================================== */

    void deleteMaterial(Long Id, Long userId) throws Exception;



    /* =================================================== WRAPPER ================================================== */
    @Deprecated
    MaterialReadDTO wrapDTO(Material material) throws Exception;

    @Deprecated
    List<MaterialReadDTO> wrapListDTO(Collection<Material> materialsCollection) throws Exception;

    @Deprecated
    Page<MaterialReadDTO> wrapPageDTO(Page<Material> newsPage) throws Exception;
}
