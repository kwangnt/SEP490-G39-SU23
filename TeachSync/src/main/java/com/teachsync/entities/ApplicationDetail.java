package com.teachsync.entities;

import com.teachsync.utils.enums.ApplicationDetailType;
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
@Table(name = "application_detail")
public class ApplicationDetail extends BaseEntity {
    @Column(name = "applicationId", nullable = false)
    private Long applicationId;

    @Column(name = "detailType", nullable = false, length = 45)
    private ApplicationDetailType detailType;

    @Lob
    @Column(name = "detailLink", nullable = false, length = -1)
    private String detailLink;

    @Lob
    @Column(name = "detailNote", nullable = false, length = -1)
    private String detailNote;

    @Column(name = "submitAt", nullable = true)
    private LocalDateTime submitAt;
}