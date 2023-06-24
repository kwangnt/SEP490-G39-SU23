package com.teachsync.dtos.courseSchedule;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.utils.enums.ScheduleType;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO for {@link com.teachsync.entities.CourseSchedule}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseScheduleReadDTO extends BaseReadDTO {
    private Long courseId;

    private Long courseName;

    private Long centerId;

    private Long centerName;

    private String scheduleAlias;

    private ScheduleType scheduleType;

    private LocalDate startDate;

    private LocalDate endDate;
}