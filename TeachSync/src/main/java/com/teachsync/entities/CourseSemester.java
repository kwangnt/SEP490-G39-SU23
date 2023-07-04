package com.teachsync.entities;

import com.teachsync.utils.enums.ScheduleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

/**Học kỳ của khóa học*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course_semester", schema = "teachsync")
public class CourseSemester extends BaseEntity {
    @Column(name = "courseId", nullable = false)
    private Long courseId;
    
    @Column(name = "semesterId", nullable = false)
    private Long semesterId;
    
    @Column(name = "centerId", nullable = false)
    private Long centerId;
}