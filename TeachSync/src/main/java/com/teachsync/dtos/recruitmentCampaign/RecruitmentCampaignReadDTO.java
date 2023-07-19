package com.teachsync.dtos.recruitmentCampaign;
import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.campaignApplication.CampaignApplicationReadDTO;
import com.teachsync.dtos.center.CenterReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.teachsync.entities.RecruitmentCampaign}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentCampaignReadDTO extends BaseReadDTO {
    private CenterReadDTO center;
    private Long centerId;

    private String campaignImg;

    private String campaignName;

    private String campaignDesc;

    private String position;

    private Integer openingSlot;

    private LocalDateTime recruitFrom;

    private LocalDateTime recruitTo;

    private List<CampaignApplicationReadDTO> applicationList;
}