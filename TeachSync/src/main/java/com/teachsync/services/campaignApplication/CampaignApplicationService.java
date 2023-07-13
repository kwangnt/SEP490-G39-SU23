package com.teachsync.services.campaignApplication;

import com.teachsync.dtos.campaignApplication.CampaignApplicationReadDTO;
import com.teachsync.entities.CampaignApplication;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface CampaignApplicationService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    CampaignApplicationReadDTO wrapDTO(CampaignApplication campaignApplication, Collection<DtoOption> options) throws Exception;
    List<CampaignApplicationReadDTO> wrapListDTO(Collection<CampaignApplication> campaignApplicationCollection, Collection<DtoOption> options) throws Exception;
    Page<CampaignApplicationReadDTO> wrapPageDTO(Page<CampaignApplication> campaignApplicationPage, Collection<DtoOption> options) throws Exception;
}
