package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "test")
public class Test extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseId", referencedColumnName = "id", nullable = false)
    private Course course;
    @Positive
    @Column(name = "courseId", insertable = false, updatable = false)
    private Long courseId;

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "testName", length = 45)
    private String testName;

    @Lob
    @Column(name = "testDesc")
    private String testDesc;
}
