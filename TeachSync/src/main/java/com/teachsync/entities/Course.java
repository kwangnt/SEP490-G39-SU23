package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "course")
public class Course extends BaseEntity {
    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "courseName", nullable = false, length = 45)
    private String courseName;

    @Lob
    @Column(name = "courseDesc")
    private String courseDesc;
}
