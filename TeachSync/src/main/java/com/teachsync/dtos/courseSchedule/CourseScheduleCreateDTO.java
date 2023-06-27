package com.teachsync.dtos.courseSchedule;

import com.teachsync.dtos.BaseCreateDTO;
import com.teachsync.utils.enums.ScheduleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO for {@link com.teachsync.entities.CourseSchedule}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseScheduleCreateDTO extends BaseCreateDTO {
    @Positive
    private Long courseId;

    @Positive
    private Long centerId;

    @NotBlank
    private String scheduleAlias;

    @NotNull
    private ScheduleType scheduleType;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;
}