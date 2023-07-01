package com.teachsync.services.Material;


import com.teachsync.dtos.material.MaterialCreateDTO;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    public MaterialRepository materialRepository;

    @Autowired
    private MiscUtil miscUtil;
    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public MaterialReadDTO addMaterial(MaterialCreateDTO materialDTO, Long userId) throws Exception {
        Material material = new Material();

        material.setMaterialName(materialDTO.getMaterialName());
        //TODO : process upload file
        material.setMaterialLink(materialDTO.getMaterialLink());
        material.setMaterialContent(materialDTO.getMaterialContent());
        material.setMaterialImg(materialDTO.getMaterialImg());
        material.setStatus(materialDTO.getStatus());
        material.setCreatedBy(userId);
        Material materialDb = materialRepository.save(material);
        if (ObjectUtils.isEmpty(materialDb)) {
            throw new Exception("Tạo tài liệu thất bại");
        }

        return mapper.map(materialDb, MaterialReadDTO.class);
    }

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
    public List<Material> getAll() throws Exception {
        return null;
    }

    @Override
    public List<MaterialReadDTO> getAllDTO() throws Exception {
        return null;
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
    public Page<Material> getPageAllByIdIn(Pageable paging, Collection<Long> materialIdCollection) throws Exception {
        return null;
    }

    @Override
    public Page<MaterialReadDTO> getPageDTOAllByIdIn(Pageable paging, Collection<Long> materialIdCollection) throws Exception {
        return null;
    }

    @Override
    public List<Material> getAllByIdIn(Collection<Long> materialIdCollection) throws Exception {
        return null;
    }

    @Override
    public Map<Long, String> mapMaterialIdMaterialNameByIdIn(Collection<Long> materialIdCollection) throws Exception {
        return null;
    }

    @Override
    public MaterialReadDTO editMaterial(MaterialReadDTO materialReadDTO, Long userId) throws Exception {
        return null;
    }

    @Override
    public void deleteMaterial(Long Id, Long userId) throws Exception {

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
