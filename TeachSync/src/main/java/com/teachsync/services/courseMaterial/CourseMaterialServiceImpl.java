package com.teachsync.services.courseMaterial;

import com.teachsync.dtos.courseMaterial.CourseMaterialReadDTO;
import com.teachsync.entities.CourseMaterial;
import com.teachsync.repositories.CourseMaterialRepository;
import com.teachsync.utils.enums.DtoOption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public CourseMaterialReadDTO wrapDTO(CourseMaterial courseMaterial, Collection<DtoOption> options) throws Exception {
        CourseMaterialReadDTO dto = mapper.map(courseMaterial, CourseMaterialReadDTO.class);

        /* Add dependency */
        /* TODO:
        if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.FK)) {
                FkReadDTO fkDTO = fkService.getDTOById(courseMaterial.getFkId());
                dto.setFk(fkDTO);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                List<FkReadDTO> fkDTOList = fkService.getAllDTOById(courseMaterial.getFkId());
                dto.setFkList(fkDTOList);
            }
        }
        */

        return dto;
    }

    @Override
    public List<CourseMaterialReadDTO> wrapListDTO(Collection<CourseMaterial> courseMaterialCollection, Collection<DtoOption> options) throws Exception {
        List<CourseMaterialReadDTO> dtoList = new ArrayList<>();
        CourseMaterialReadDTO dto;

        /* TODO:
        Map<Long, FkReadDTO> fkIdFkDTOMap = new HashMap<>();
        Map<Long, List<FkReadDTO>> fkIdFkDTOListMap = new HashMap<>();

        if (options != null && !options.isEmpty()) {
            Set<Long> fkIdSet = new HashSet<>();

            for (CourseMaterial courseMaterial : courseMaterialCollection) {
                fkIdSet.add(courseMaterial.getFkId());
            }

            if (options.contains(DtoOption.FK)) {
                fkIdFkDTOMap = fkService.mapIdDTOByIdIn(fkIdSet);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                fkIdFkDTOListMap = fkService.mapIdListDTOByIdIn(fkIdSet);
            }
        }
        */

        for (CourseMaterial courseMaterial : courseMaterialCollection) {
            dto = mapper.map(courseMaterial, CourseMaterialReadDTO.class);

            /* Add dependency */
            /*
            dto.setFk(fkIdFkDTOMap.get(courseMaterial.getFkId()));

            dto.setFkList(fkIdFkDTOListMap.get(courseMaterial.getFkId()));
            */

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<CourseMaterialReadDTO> wrapPageDTO(Page<CourseMaterial> courseMaterialPage, Collection<DtoOption> options) throws Exception {
        return new PageImpl<>(
                wrapListDTO(courseMaterialPage.getContent(), options),
                courseMaterialPage.getPageable(),
                courseMaterialPage.getTotalPages());
    }
}
