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
@Table(name = "schedule_user_pair")
public class ScheduleUserPair {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleId", referencedColumnName = "id", nullable = false)
    private Schedule schedule;
    @Basic
    @Column(name = "scheduleId", insertable = false, updatable = false)
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Basic
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;

    @Basic
    @Column(name = "status")
    private Status status;
}
