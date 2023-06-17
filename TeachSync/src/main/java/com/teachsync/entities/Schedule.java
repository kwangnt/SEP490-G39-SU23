package com.teachsync.entities;

import com.teachsync.utils.enums.ScheduleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clazzId", referencedColumnName = "id", nullable = false)
    private Clazz clazz;
    @Positive
    @Column(name = "clazzId", insertable = false, updatable = false)
    private Long clazzId;

    /** Default room used, will be copied to Session */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomId", referencedColumnName = "id", nullable = false)
    private Room room;
    @Column(name = "roomId", insertable = false, updatable = false)
    private Long roomId;

    @NotNull
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;
    @NotNull
    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @PositiveOrZero
    @Range(min = 0, max = 12)
    @Column(name = "slot", nullable = false)
    private Integer slot;

    @Column(name = "sessionStart", nullable = false)
    private LocalDateTime sessionStart;

    @Column(name = "sessionEnd", nullable = false)
    private LocalDateTime sessionEnd;

    @Lob
    @Column(name = "scheduleType")
    private ScheduleType scheduleType;
}
