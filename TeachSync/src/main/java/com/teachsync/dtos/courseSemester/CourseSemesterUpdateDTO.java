package com.teachsync.dtos.courseSemester;

import com.teachsync.dtos.BaseUpdateDTO;
import com.teachsync.entities.CourseSemester;
import com.teachsync.utils.enums.ScheduleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

/**
 * DTO for {@link CourseSemester}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSemesterUpdateDTO extends BaseUpdateDTO {
    @Positive
    private Long courseId;
    
    @Positive
    private Long centerId;
    
    @Positive
    private Long semesterId;
}