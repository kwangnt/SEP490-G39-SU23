package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course_semester")
public class CourseSemester extends BaseEntity {
    @Column(name = "courseId", nullable = false)
    private Long courseId;

    @Column(name = "semesterId", nullable = false)
    private Long semesterId;

    @Column(name = "centerId", nullable = false)
    private Long centerId;
}