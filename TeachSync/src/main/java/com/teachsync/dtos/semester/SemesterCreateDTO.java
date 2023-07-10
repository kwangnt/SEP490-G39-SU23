package com.teachsync.dtos.semester;

import com.teachsync.dtos.BaseCreateDTO;
import com.teachsync.utils.enums.SemesterType;
import jakarta.persistence.Lob;
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
public class SemesterCreateDTO extends BaseCreateDTO {
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