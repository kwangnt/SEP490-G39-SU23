package com.teachsync.dtos.courseSemester;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.dtos.semester.SemesterReadDTO;
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
public class CourseSemesterReadDTO extends BaseReadDTO {
    private Long courseId;

    private String courseName;

    private String courseAlias;
    
    private Long centerId;

    private CenterReadDTO center;
    
    private SemesterReadDTO semester;
}