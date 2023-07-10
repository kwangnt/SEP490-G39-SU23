package com.teachsync.dtos.courseSemester;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.center.CenterReadDTO;
import com.teachsync.dtos.semester.SemesterReadDTO;
import com.teachsync.entities.CourseSemester;
import com.teachsync.utils.enums.ScheduleType;
import com.teachsync.utils.enums.SemesterType;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDate;

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