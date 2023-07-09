package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "recruitment_campaign")
public class RecruitmentCampaign extends BaseEntity {
    @Column(name = "centerId", nullable = false)
    private Long centerId;

    @Lob
    @Column(name = "campaignImg", nullable = false, length = -1)
    private String campaignImg;

    @Column(name = "campaignName", nullable = false, length = 45)
    private String campaignName;

    @Lob
    @Column(name = "campaignDesc", nullable = true, length = -1)
    private String campaignDesc;

    @Column(name = "position", nullable = false, length = 45)
    private String position;

    @Column(name = "openingSlot", nullable = false)
    private Integer openingSlot;

    @Column(name = "recruitFrom", nullable = false)
    private LocalDateTime recruitFrom;

    @Column(name = "recruitTo", nullable = false)
    private LocalDateTime recruitTo;
}