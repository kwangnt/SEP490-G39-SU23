package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clazz")
public class Clazz extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "courseId", referencedColumnName = "id", nullable = false)
    private Course course;
    @Positive
    @Column(name = "courseId", insertable = false, updatable = false)
    private Long courseId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomId", referencedColumnName = "id", nullable = false)
    private Room room;
    @Column(name = "roomId", insertable = false, updatable = false)
    private Long roomId;

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "className", nullable = false, length = 45)
    private String className;

    @Lob
    @Column(name = "classDesc")
    private String classDesc;
}
