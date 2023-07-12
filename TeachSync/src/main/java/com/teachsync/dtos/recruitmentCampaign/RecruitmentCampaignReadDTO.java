package com.teachsync.dtos.recruitmentCampaign;
import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.RecruitmentCampaign}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentCampaignReadDTO extends BaseReadDTO {
    private Long centerId;
    private String campaignImg;
    private String campaignName;
    private String campaignDesc;
    private String position;
    private Integer openingSlot;
    private LocalDateTime recruitFrom;
    private LocalDateTime recruitTo;
}