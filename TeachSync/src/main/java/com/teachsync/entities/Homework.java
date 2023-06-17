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
@Table(name = "homework")
public class Homework extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classId", referencedColumnName = "id", nullable = false)
    private Clazz clazz;
    @Positive
    @Column(name = "classId", insertable = false, updatable = false)
    private Long classId;

    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "homeworkName", nullable = false, length = 45)
    private String homeworkName;

    @Lob
    @Column(name = "homeworkDesc")
    private String homeworkDesc;
}
