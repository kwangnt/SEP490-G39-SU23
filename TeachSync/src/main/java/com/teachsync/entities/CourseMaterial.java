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
@Table(name = "course_material")
public class CourseMaterial extends BaseEntity {
    @Column(name = "courseId", nullable = false)
    private Long courseId;

    @Column(name = "materialId", nullable = false)
    private Long materialId;
}