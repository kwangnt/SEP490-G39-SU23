package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "session")
public class Session extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "scheduleId", referencedColumnName = "id", nullable = false)
    private Schedule schedule;
    @Column(name = "scheduleId", insertable = false, updatable = false)
    private Long scheduleId;

    /** Actual Room used at session, may differ from Schedule.room */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roomId", referencedColumnName = "id", nullable = false)
    private Room room;
    @Column(name = "roomId", insertable = false, updatable = false)
    private Long roomId;

    @PositiveOrZero
    @Range(min = 0, max = 12)
    @Column(name = "slot", nullable = false)
    private Integer slot;

    @Column(name = "sessionStart", nullable = false)
    private LocalDateTime sessionStart;

    @Column(name = "sessionEnd", nullable = false)
    private LocalDateTime sessionEnd;

}
