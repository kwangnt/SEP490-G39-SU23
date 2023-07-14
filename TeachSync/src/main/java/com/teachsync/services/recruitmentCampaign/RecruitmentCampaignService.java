package com.teachsync.services.recruitmentCampaign;

import com.teachsync.dtos.recruitmentCampaign.RecruitmentCampaignReadDTO;
import com.teachsync.entities.RecruitmentCampaign;
import com.teachsync.utils.enums.DtoOption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface RecruitmentCampaignService {
    /* =================================================== CREATE =================================================== */


    /* =================================================== READ ===================================================== */
    Page<RecruitmentCampaign> getPageAll(Pageable pageable) throws Exception;
    Page<RecruitmentCampaignReadDTO> getPageAllDTO(Pageable pageable, Collection<DtoOption> options) throws Exception;

    /* id */
    RecruitmentCampaign getById(Long id) throws Exception;
    RecruitmentCampaignReadDTO getDTOById(Long id, Collection<DtoOption> options) throws Exception;

    List<RecruitmentCampaign> getAllByIdIn(Collection<Long> idCollection) throws Exception;
    List<RecruitmentCampaignReadDTO> getAllDTOByIdIn(
            Collection<Long> idCollection, Collection<DtoOption> options) throws Exception;
    Map<Long, RecruitmentCampaignReadDTO> mapIdDTOByIdIn(
            Collection<Long> idCollection, Collection<DtoOption> options) throws Exception;

    /* centerId */
    Page<RecruitmentCampaign> getPageAllByCenterId(Long centerId, Pageable pageable) throws Exception;
    Page<RecruitmentCampaignReadDTO> getPageAllDTOByCenterId(
            Long centerId, Pageable pageable, Collection<DtoOption> options) throws Exception;

    List<RecruitmentCampaign> getAllByCenterId(Long centerId) throws Exception;
    List<RecruitmentCampaignReadDTO> getAllDTOByCenterId(Long centerId, Collection<DtoOption> options) throws Exception;


    /* =================================================== UPDATE =================================================== */


    /* =================================================== DELETE =================================================== */


    /* =================================================== WRAPPER ================================================== */
    RecruitmentCampaignReadDTO wrapDTO(
            RecruitmentCampaign campaign, Collection<DtoOption> options) throws Exception;
    List<RecruitmentCampaignReadDTO> wrapListDTO(
            Collection<RecruitmentCampaign> campaignCollection, Collection<DtoOption> options) throws Exception;
    Page<RecruitmentCampaignReadDTO> wrapPageDTO(
            Page<RecruitmentCampaign> campaignPage, Collection<DtoOption> options) throws Exception;
}
