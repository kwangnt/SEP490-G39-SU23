package com.teachsync.services.campaignApplication;

import com.teachsync.dtos.campaignApplication.CampaignApplicationReadDTO;
import com.teachsync.entities.CampaignApplication;
import com.teachsync.repositories.CampaignApplicationRepository;
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
public class CampaignApplicationServiceImpl implements CampaignApplicationService {
    @Autowired
    private CampaignApplicationRepository campaignApplicationRepository;

    @Autowired
    private ModelMapper mapper;


    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    @Override
    public CampaignApplicationReadDTO wrapDTO(CampaignApplication campaignApplication, Collection<DtoOption> options) throws Exception {
        CampaignApplicationReadDTO dto = mapper.map(campaignApplication, CampaignApplicationReadDTO.class);

        /* Add dependency */
        /* TODO:
        if (options != null && !options.isEmpty()) {
            if (options.contains(DtoOption.FK)) {
                FkReadDTO fkDTO = fkService.getDTOById(campaignApplication.getFkId());
                dto.setFk(fkDTO);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                List<FkReadDTO> fkDTOList = fkService.getAllDTOById(campaignApplication.getFkId());
                dto.setFkList(fkDTOList);
            }
        }
        */

        return dto;
    }

    @Override
    public List<CampaignApplicationReadDTO> wrapListDTO(Collection<CampaignApplication> campaignApplicationCollection, Collection<DtoOption> options) throws Exception {
        List<CampaignApplicationReadDTO> dtoList = new ArrayList<>();
        CampaignApplicationReadDTO dto;

        /* TODO:
        Map<Long, FkReadDTO> fkIdFkDTOMap = new HashMap<>();
        Map<Long, List<FkReadDTO>> fkIdFkDTOListMap = new HashMap<>();

        if (options != null && !options.isEmpty()) {
            Set<Long> fkIdSet = new HashSet<>();

            for (CampaignApplication campaignApplication : campaignApplicationCollection) {
                fkIdSet.add(campaignApplication.getFkId());
            }

            if (options.contains(DtoOption.FK)) {
                fkIdFkDTOMap = fkService.mapIdDTOByIdIn(fkIdSet);
            }

            if (options.contains(DtoOption.FK_LIST)) {
                fkIdFkDTOListMap = fkService.mapIdListDTOByIdIn(fkIdSet);
            }
        }
        */

        for (CampaignApplication campaignApplication : campaignApplicationCollection) {
            dto = mapper.map(campaignApplication, CampaignApplicationReadDTO.class);

            /* Add dependency */
            /*
            dto.setFk(fkIdFkDTOMap.get(campaignApplication.getFkId()));

            dto.setFkList(fkIdFkDTOListMap.get(campaignApplication.getFkId()));
            */

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public Page<CampaignApplicationReadDTO> wrapPageDTO(Page<CampaignApplication> campaignApplicationPage, Collection<DtoOption> options) throws Exception {
        return new PageImpl<>(
                wrapListDTO(campaignApplicationPage.getContent(), options),
                campaignApplicationPage.getPageable(),
                campaignApplicationPage.getTotalPages());
    }
}
