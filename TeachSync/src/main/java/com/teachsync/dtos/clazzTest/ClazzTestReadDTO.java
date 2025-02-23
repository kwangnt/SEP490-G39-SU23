package com.teachsync.dtos.clazzTest;
import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.test.TestReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.ClazzTest}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzTestReadDTO extends BaseReadDTO {
    private Long clazzId;
    private Long testId;
    private TestReadDTO test;
    private LocalDateTime openFrom;
    private LocalDateTime openTo;
}