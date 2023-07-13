package com.teachsync.services.recruitmentCampaign;

import com.teachsync.dtos.recruitmentCampaign.RecruitmentCampaignReadDTO;
import com.teachsync.entities.RecruitmentCampaign;
import com.teachsync.repositories.RecruitmentCampaignRepository;
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
public class RecruitmentCampaignServiceImpl implements RecruitmentCampaignService {
    @Autowired
    private RecruitmentCampaignRepository recruitmentCampaignRepository;

    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public RecruitmentCampaignReadDTO wrapDTO(RecruitmentCampaign recruitmentCampaign, Collection<DtoOption> options) throws Exception {
        RecruitmentCampaignReadDTO dto = mapper.map(recruitmentCampaign, RecruitmentCampaignReadDTO.class);

        /* Add dependency */
        /* TODO:
        if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.FK)) {
                FkReadDTO fkDTO = fkService.getDTOById(recruitmentCampaign.getFkId());
                dto.setFk(fkDTO);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                List<FkReadDTO> fkDTOList = fkService.getAllDTOById(recruitmentCampaign.getFkId());
                dto.setFkList(fkDTOList);
            }
        }
        */

        return dto;
    }

    @Override
    public List<RecruitmentCampaignReadDTO> wrapListDTO(Collection<RecruitmentCampaign> recruitmentCampaignCollection, Collection<DtoOption> options) throws Exception {
        List<RecruitmentCampaignReadDTO> dtoList = new ArrayList<>();
        RecruitmentCampaignReadDTO dto;

        /* TODO:
        Map<Long, FkReadDTO> fkIdFkDTOMap = new HashMap<>();
        Map<Long, List<FkReadDTO>> fkIdFkDTOListMap = new HashMap<>();

        if (options != null && !options.isEmpty()) {
            Set<Long> fkIdSet = new HashSet<>();

            for (RecruitmentCampaign recruitmentCampaign : recruitmentCampaignCollection) {
                fkIdSet.add(recruitmentCampaign.getFkId());
            }

            if (options.contains(DtoOption.FK)) {
                fkIdFkDTOMap = fkService.mapIdDTOByIdIn(fkIdSet);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                fkIdFkDTOListMap = fkService.mapIdListDTOByIdIn(fkIdSet);
            }
        }
        */

        for (RecruitmentCampaign recruitmentCampaign : recruitmentCampaignCollection) {
            dto = mapper.map(recruitmentCampaign, RecruitmentCampaignReadDTO.class);

            /* Add dependency */
            /*
            dto.setFk(fkIdFkDTOMap.get(recruitmentCampaign.getFkId()));

            dto.setFkList(fkIdFkDTOListMap.get(recruitmentCampaign.getFkId()));
            */

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<RecruitmentCampaignReadDTO> wrapPageDTO(Page<RecruitmentCampaign> recruitmentCampaignPage, Collection<DtoOption> options) throws Exception {
        return new PageImpl<>(
                wrapListDTO(recruitmentCampaignPage.getContent(), options),
                recruitmentCampaignPage.getPageable(),
                recruitmentCampaignPage.getTotalPages());
    }
}
