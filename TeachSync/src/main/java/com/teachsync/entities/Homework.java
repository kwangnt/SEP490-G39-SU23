package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
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
public class Homework {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classId", referencedColumnName = "id", nullable = false)
    private Classroom classroom;
    @Basic
    @Column(name = "classId", insertable = false, updatable = false)
    private Long classId;

    @Basic
    @Column(name = "homeworkName")
    private String homeworkName;

    @Basic
    @Column(name = "homeworkDesc")
    private String homeworkDesc;

    @Basic
    @Column(name = "status")
    private Status status;
}
