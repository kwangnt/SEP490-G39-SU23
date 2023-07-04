package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Course extends BaseEntity {
    @Column(name = "courseName", nullable = false, length = 45)
    private String courseName;

    @Column(name = "courseAlias", nullable = false, length = 10)
    private String courseAlias;

    @Lob
    @Column(name = "courseImg", nullable = false, length = -1)
    private String courseImg;

    @Lob
    @Column(name = "courseDesc", nullable = true, length = -1)
    private String courseDesc;

    @Column(name = "numSession", nullable = false)
    private Integer numSession;

    @Column(name = "minScore", nullable = false, precision = 0)
    private Double minScore;
    
    @Column(name = "minAttendant", nullable = false, precision = 0)
    private Double minAttendant;
}