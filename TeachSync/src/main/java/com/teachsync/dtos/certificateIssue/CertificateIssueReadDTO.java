package com.teachsync.dtos.certificateIssue;

import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.CertificateIssue}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateIssueReadDTO extends BaseReadDTO {
    private Long receiverId;
    private Long certificateId;
    private Long semesterId;
    private Long signatoryId;
    private Long presenterId;
    private LocalDateTime issuedAt;
    private LocalDateTime printedAt;
}