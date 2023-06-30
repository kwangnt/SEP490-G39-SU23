package com.teachsync.dtos.course;

import com.teachsync.dtos.BaseUpdateDTO;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class CourseUpdateDTO extends BaseUpdateDTO {
    @NotNull
    @Positive
    private Long id;

    @NotBlank
    @Size(min = 1, max = 45)
    private String courseName;

    @Lob
    private String courseDesc;

    private Status status = Status.UPDATED;
}
