package com.teachsync.dtos.semester;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.utils.enums.SemesterType;
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
public class SemesterReadDTO extends BaseReadDTO {
    private String semesterName;
    
    private String semesterAlias;
    
    private String semesterDesc;
    
    private SemesterType semesterType;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
}