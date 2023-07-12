package com.teachsync.services.Material;


import com.teachsync.dtos.material.MaterialCreateDTO;
import com.teachsync.dtos.material.MaterialReadDTO;
import com.teachsync.entities.BaseEntity;
import com.teachsync.entities.Material;
import com.teachsync.repositories.MaterialRepository;
import com.teachsync.utils.MiscUtil;
import com.teachsync.utils.converters.MaterialTypeConverter;
import com.teachsync.utils.enums.MaterialType;
import com.teachsync.utils.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    public MaterialRepository materialRepository;

    @Autowired
    private MiscUtil miscUtil;
    @Autowired
    private ModelMapper mapper;

    /* =================================================== CREATE =================================================== */
    @Override
    @Transactional
    public MaterialReadDTO addMaterial(MaterialCreateDTO materialDTO, Long userId) throws Exception {
        Material material = new Material();

        material.setMaterialName(materialDTO.getMaterialName());
        //TODO : process upload file
        material.setMaterialLink(materialDTO.getMaterialLink());
        material.setMaterialContent(materialDTO.getMaterialContent());
        material.setMaterialImg(materialDTO.getMaterialImg());
        material.setMaterialType(materialDTO.getMaterialType());
        material.setIsFree(materialDTO.isFree());
        material.setStatus(materialDTO.getStatus());
        material.setCreatedBy(userId);
        Material materialDb = materialRepository.save(material);
        if (ObjectUtils.isEmpty(materialDb)) {
            throw new Exception("Tạo tài liệu thất bại");
        }


        return mapper.map(materialDb, MaterialReadDTO.class);
    }
    /* =================================================== READ ===================================================== */
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
        List<Material> materialPage =
                materialRepository.findAllByStatusNot(Status.DELETED);

        if (materialPage.isEmpty()) {
            return null;
        }

        return materialPage;
    }

    @Override
    public List<MaterialReadDTO> getAllDTO() throws Exception {
        List<Material> materialList = getAll();

        if (materialList == null) {
            return null;
        }

        return wrapListDTO(materialList);
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
        if (paging == null) {
            paging = miscUtil.defaultPaging(); }

        Page<Material> materialPage =
                materialRepository.findAllByIdInAndStatusNot(materialIdCollection, Status.DELETED, paging);

        if (materialPage.isEmpty()) {
            return null; }

        return materialPage;
    }

    @Override
    public Page<MaterialReadDTO> getPageDTOAllByIdIn(Pageable paging, Collection<Long> materialIdCollection) throws Exception {
        Page<Material> materialPage = getPageAllByIdIn(paging, materialIdCollection);

        if (materialPage == null) {
            return null; }

        return wrapPageDTO(materialPage);
    }

    @Override
    public List<Material> getAllByIdIn(Collection<Long> materialIdCollection) throws Exception {
        List<Material>  materialList =
                materialRepository.findAllByIdInAndStatusNot(materialIdCollection, Status.DELETED);

        if (materialList.isEmpty()) {
            return null; }

        return materialList;
    }

    @Override
    public Map<Long, String> mapMaterialIdMaterialNameByIdIn(Collection<Long> materialIdCollection) throws Exception {
        List<Material> materialList = getAllByIdIn(materialIdCollection);

        if (materialList.isEmpty()) {
            return new HashMap<>(); }

        return materialList.stream()
                .collect(Collectors.toMap(BaseEntity::getId, Material::getMaterialName));
    }

    /* =================================================== UPDATE =================================================== */
    @Override
    @Transactional
    public MaterialReadDTO editMaterial(MaterialReadDTO materialReadDTO, Long userId) throws Exception {
        Material material = materialRepository.findById(materialReadDTO.getId()).orElseThrow(() -> new Exception("không tìm thấy tài liệu"));

        material.setMaterialName(materialReadDTO.getMaterialName());
        //TODO : process upload file
        material.setMaterialLink(materialReadDTO.getMaterialLink());
        material.setMaterialContent(materialReadDTO.getMaterialContent());
        material.setMaterialImg(materialReadDTO.getMaterialImg());
        material.setMaterialType(MaterialType.valueOf(String.valueOf(materialReadDTO.getMaterialType())));
        material.setIsFree(materialReadDTO.getIsFree());
        material.setStatus(Status.UPDATED);
        material.setUpdatedBy(userId);
        Material materialDb = materialRepository.save(material);
        if (ObjectUtils.isEmpty(materialDb)) {
            throw new Exception("Cập nhật tài liệu thất bại");
        }

        return mapper.map(materialDb, MaterialReadDTO.class);
    }
    /* =================================================== DELETE =================================================== */
    @Override
    @Transactional
    public void deleteMaterial(Long Id, Long userId) throws Exception {
        Material material = materialRepository.findById(Id).orElseThrow(() -> new Exception("không tìm thấy tài liệu"));
        material.setStatus(Status.DELETED);
        material.setUpdatedBy(userId);
        materialRepository.save(material);
    }
    /* =================================================== WRAPPER ================================================== */
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
