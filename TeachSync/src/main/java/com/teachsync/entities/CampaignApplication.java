package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "campaign_application")
public class CampaignApplication extends BaseEntity {
    @Column(name = "campaignId", nullable = false)
    private Long campaignId;

    /** => User : Long userId */
    @Column(name = "applicantId", nullable = false)
    private Long applicantId;

    @Column(name = "appliedAt", nullable = false)
    private LocalDateTime appliedAt;

    @Column(name = "result", nullable = false, length = 45)
    private String result;

    @Column(name = "resultDate", nullable = true)
    private LocalDateTime resultDate;
}