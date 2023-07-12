package com.teachsync.dtos.session;
import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.Session}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionReadDTO extends BaseReadDTO {
    private Long roomId;
    private Long scheduleId;
    private Long staffId;
    private Integer slot;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
}