package com.teachsync.dtos.applicationDetail;
import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.ApplicationDetail}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDetailReadDTO extends BaseReadDTO {
    private Long applicationId;
    private String detailType;
    private String detailLink;
    private String detailNote;
    private LocalDateTime submitAt;
}