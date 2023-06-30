package com.teachsync.services.Material;


import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.entities.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public class MaterialServiceImpl implements MaterialService {
    @Override
    public Page<Material> getPageAll(Pageable paging) throws Exception {
        return null;
    }

    @Override
    public Page<MaterialReadDTO> getPageDTOAll(Pageable paging) throws Exception {
        return null;
    }

    @Override
    public Material getById(Long id) throws Exception {
        return null;
    }

    @Override
    public MaterialReadDTO getDTOById(Long id) throws Exception {
        return null;
    }

    @Override
    public MaterialReadDTO wrapDTO(Material material) throws Exception {
        return null;
    }

    @Override
    public List<MaterialReadDTO> wrapListDTO(Collection<Material> materialsCollection) throws Exception {
        return null;
    }

    @Override
    public Page<MaterialReadDTO> wrapPageDTO(Page<Material> newsPage) throws Exception {
        return null;
    }
}
