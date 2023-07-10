package com.teachsync.dtos.semester;

import com.teachsync.dtos.BaseUpdateDTO;
import com.teachsync.entities.CourseSemester;
import com.teachsync.utils.enums.ScheduleType;
import com.teachsync.utils.enums.SemesterType;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO for {@link com.teachsync.entities.Semester}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterUpdateDTO extends BaseUpdateDTO {
    private String semesterName;
    
    private String semesterAlias;
    
    @Lob
    private String semesterDesc;
    
    private SemesterType semesterType;
    
    /** Must be before endDate */
    private LocalDate startDate;
    
    /** Must be after startDate */
    private LocalDate endDate;
}