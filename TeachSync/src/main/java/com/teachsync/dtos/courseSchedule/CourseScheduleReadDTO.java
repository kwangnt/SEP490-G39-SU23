package com.teachsync.dtos.courseSchedule;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.utils.enums.ScheduleType;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO for {@link com.teachsync.entities.CourseSchedule}
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class CourseScheduleReadDTO extends BaseReadDTO {
    private Long courseId;

    private Long centerId;

    private String scheduleAlias;

    private ScheduleType scheduleType;

    private LocalDate startDate;

    private LocalDate endDate;
}