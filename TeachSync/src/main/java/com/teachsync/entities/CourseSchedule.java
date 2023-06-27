package com.teachsync.entities;

import com.teachsync.utils.enums.ScheduleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

/**Học kỳ của khóa học*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course_schedule", schema = "teachsync")
public class CourseSchedule extends BaseEntity {
    @Column(name = "courseId", nullable = false)
    private Long courseId;
    
    @Column(name = "centerId", nullable = false)
    private Long centerId;
    
    @Column(name = "scheduleAlias", nullable = false, length = 45)
    private String scheduleAlias;

    @Lob
    @Column(name = "scheduleType", nullable = false, length = -1)
    private ScheduleType scheduleType;
    
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;
    
    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;
}