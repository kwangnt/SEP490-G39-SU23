package com.teachsync.entities;

import com.teachsync.utils.enums.SemesterType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "semester")
public class Semester extends BaseEntity {
    @Column(name = "semesterName", nullable = false, length = 45)
    private String semesterName;

    @Column(name = "semesterAlias", nullable = false, length = 10)
    private String semesterAlias;

    @Lob
    @Column(name = "semesterDesc", nullable = true, length = -1)
    private String semesterDesc;

    @Column(name = "semesterType", nullable = false, length = 45)
    private SemesterType semesterType;

    /** Must be before endDate */
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    /** Must be after startDate */
    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;
}