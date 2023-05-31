package com.teachsync.entities;

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
@Table(name = "test")
public class Test {
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
    @Column(name = "testName")
    private String testName;

    @Basic
    @Column(name = "testDesc")
    private String testDesc;

    @Basic
    @Column(name = "status")
    private String status;
}
