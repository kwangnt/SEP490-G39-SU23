package com.teachsync.entities;

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
@Table(name = "course")
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "courseName")
    private String courseName;

    @Basic
    @Column(name = "courseDesc")
    private String courseDesc;

    @Basic
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Classroom> classroomList;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Material> materialList;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<PriceLog> priceLogList;
}
