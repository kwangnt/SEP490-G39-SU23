package com.teachsync.entities;

import com.teachsync.utils.enums.ScheduleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clazz_schedule", schema = "teachsync")
public class ClazzSchedule extends BaseEntity {
//    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
//    @JoinColumn(name = "clazzId", nullable = false)
//    private Clazz clazz;
    @Column(name = "clazzId", nullable = false)
    private Long clazzId;
    
    @Column(name = "roomId", nullable = false)
    private Long roomId;
    
    @Column(name = "scheduleType", nullable = false, length = 45)
    private ScheduleType scheduleType;
    
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;
    
    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;
    
    @Column(name = "slot", nullable = true)
    private Integer slot;

    @Column(name = "sessionStart", nullable = false)
    private LocalTime sessionStart;

    @Column(name = "sessionEnd", nullable = false)
    private LocalTime sessionEnd;
}