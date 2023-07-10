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
@Table(name = "certificate_issue")
public class CertificateIssue extends BaseEntity {
    /** => User : Long userId */
    @Column(name = "receiverId", nullable = false)
    private Long receiverId;

    @Column(name = "certificateId", nullable = false)
    private Long certificateId;

    @Column(name = "semesterId", nullable = false)
    private Long semesterId;

    /** => User : Long userId */
    @Column(name = "signatoryId", nullable = false)
    private Long signatoryId;

    /** => User : Long userId */
    @Column(name = "presenterId", nullable = false)
    private Long presenterId;

    @Column(name = "issuedAt", nullable = true)
    private LocalDateTime issuedAt;

    @Column(name = "printedAt", nullable = true)
    private LocalDateTime printedAt;
}