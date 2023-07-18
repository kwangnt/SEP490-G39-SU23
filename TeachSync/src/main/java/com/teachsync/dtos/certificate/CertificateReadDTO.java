package com.teachsync.dtos.certificate;
import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Certificate}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateReadDTO extends BaseReadDTO {
    private Long courseId;
    private String certificateName;
    private String certificateDesc;
    private String certificateImg;
    private String certificateLink;
    private byte[] certificateContent;
}