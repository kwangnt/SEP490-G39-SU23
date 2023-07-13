package com.teachsync.dtos.campaignApplication;
import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.CampaignApplication}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignApplicationReadDTO extends BaseReadDTO {
    private Long campaignId;
    private Long applicantId;
    private LocalDateTime appliedAt;
    private String result;
    private LocalDateTime resultDate;
}