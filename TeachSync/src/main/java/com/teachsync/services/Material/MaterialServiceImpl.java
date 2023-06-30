package com.teachsync.services.Material;


import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.entities.Material;
import com.teachsync.repositories.MaterialRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    public MaterialRepository materialRepository;

    @Autowired
    private MiscUtil miscUtil;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Material> getPageAll(Pageable paging) throws Exception {
        if (paging == null) {
            paging = miscUtil.defaultPaging(); }

        Page<Material> materialPage =
                materialRepository.findAllByStatusNot(Status.DELETED, paging);

        if (materialPage.isEmpty()) {
            return null; }

        return materialPage;
    }

    @Override
    public Page<MaterialReadDTO> getPageDTOAll(Pageable paging) throws Exception {
        Page<Material> materialPage = getPageAll(paging);

        if (materialPage == null) {
            return null; }

        return wrapPageDTO(materialPage);
    }

    @Override
    public Material getById(Long id) throws Exception {
        Optional<Material> news =
                materialRepository.findByIdAndStatusNot(id, Status.DELETED);

        return news.orElse(null);
    }

    @Override
    public MaterialReadDTO getDTOById(Long id) throws Exception {
        Material material = getById(id);

        if (material == null) {
            return null; }

        return wrapDTO(material);
    }

    @Override
    public MaterialReadDTO wrapDTO(Material material) throws Exception {
        MaterialReadDTO dto = mapper.map(material, MaterialReadDTO.class);

        return dto;
    }

    @Override
    public List<MaterialReadDTO> wrapListDTO(Collection<Material> materialsCollection) throws Exception {
        List<MaterialReadDTO> dtoList = new ArrayList<>();

        MaterialReadDTO dto;

        for (Material news : materialsCollection) {
            dto = mapper.map(news, MaterialReadDTO.class);


            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<MaterialReadDTO> wrapPageDTO(Page<Material> newsPage) throws Exception {
        return new PageImpl<>(
                wrapListDTO(newsPage.getContent()),
                newsPage.getPageable(),
                newsPage.getTotalPages());
    }
}
