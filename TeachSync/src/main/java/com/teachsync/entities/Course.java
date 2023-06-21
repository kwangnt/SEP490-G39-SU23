package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course extends BaseEntity {
    @Column(name = "courseName", nullable = false, length = 45)
    private String courseName;

    @Lob
    @Column(name = "courseImg", nullable = false, length = -1)
    private String courseImg;

    @Lob
    @Column(name = "courseDesc", nullable = true, length = -1)
    private String courseDesc;
    
    @Column(name = "minScore", nullable = false, precision = 0)
    private Double minScore;
    
    @Column(name = "minAttendant", nullable = false, precision = 0)
    private Double minAttendant;
}