package com.teachsync.dtos.courseSemester;

import com.teachsync.dtos.BaseCreateDTO;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.CourseSemester}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSemesterCreateDTO extends BaseCreateDTO {
    @Positive
    private Long courseId;

    @Positive
    private Long centerId;

    @Positive
    private Long semesterId;
}