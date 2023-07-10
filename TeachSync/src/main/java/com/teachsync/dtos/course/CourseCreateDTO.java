package com.teachsync.dtos.course;

import com.teachsync.dtos.BaseCreateDTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Course}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateDTO extends BaseCreateDTO {
    @NotBlank
    @Size(min = 1, max = 45)
    private String courseName;

    private String courseImg;

    private String courseDesc;

    @NotNull
    @Min(1)
    @Positive
    private Double price;

    private Double minScore;

    private Double minAttendant;
}
