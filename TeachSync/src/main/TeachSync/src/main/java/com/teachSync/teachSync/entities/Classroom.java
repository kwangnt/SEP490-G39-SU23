package com.teachSync.teachSync.entities;

import jakarta.persistence.*;
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
@Table(name = "classroom")
public class Classroom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId", referencedColumnName = "id", nullable = false)
    private Course course;
    @Basic
    @Column(name = "courseId", insertable = false, updatable = false)
    private Long courseId;

    @Basic
    @Column(name = "className")
    private String className;

    @Basic
    @Column(name = "classDesc")
    private String classDesc;

    @Basic
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Homework> homeworkList;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Schedule> scheduleList;

    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Test> testList;
}
