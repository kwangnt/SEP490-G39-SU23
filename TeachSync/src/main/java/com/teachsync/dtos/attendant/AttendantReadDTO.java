package com.teachsync.dtos.attendant;
import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Attendant}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendantReadDTO extends BaseReadDTO {
    private Long sessionId;
    private Long memberId;
    private Boolean isPresent;
}