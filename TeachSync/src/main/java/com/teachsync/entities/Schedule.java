package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
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
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "slot")
    private Integer slot;

    @Basic
    @Column(name = "scheduleDesc")
    private String scheduleDesc;

    @Basic
    @Column(name = "status")
    private Status status;
}
