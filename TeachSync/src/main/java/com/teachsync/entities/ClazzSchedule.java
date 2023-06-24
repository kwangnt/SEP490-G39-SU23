package com.teachsync.entities;

import com.teachsync.utils.enums.ScheduleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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