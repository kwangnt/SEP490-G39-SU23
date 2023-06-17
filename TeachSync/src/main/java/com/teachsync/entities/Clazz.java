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

/**
 * This <b>@Entity</b> is name <b>Clazz</b> to avoid conflict with the basic concept of <b>Class</b> in Java and OOP
 * */
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

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "clazzName", nullable = false, length = 45)
    private String clazzName;

    @Lob
    @Column(name = "clazzDesc")
    private String clazzDesc;
}
