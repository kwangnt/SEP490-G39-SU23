package com.teachsync.services.recruitmentCampaign;

import com.teachsync.dtos.recruitmentCampaign.RecruitmentCampaignReadDTO;
import com.teachsync.entities.RecruitmentCampaign;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface RecruitmentCampaignService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    RecruitmentCampaignReadDTO wrapDTO(RecruitmentCampaign recruitmentCampaign, Collection<DtoOption> options) throws Exception;
    List<RecruitmentCampaignReadDTO> wrapListDTO(Collection<RecruitmentCampaign> recruitmentCampaignCollection, Collection<DtoOption> options) throws Exception;
    Page<RecruitmentCampaignReadDTO> wrapPageDTO(Page<RecruitmentCampaign> recruitmentCampaignPage, Collection<DtoOption> options) throws Exception;
}
