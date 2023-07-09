package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "session")
public class Session extends BaseEntity {
    @Column(name = "roomId", nullable = false)
    private Long roomId;

    @Column(name = "scheduleId", nullable = false)
    private Long scheduleId;

    @Column(name = "staffId", nullable = false)
    private Long staffId;

    @Column(name = "slot", nullable = true)
    private Integer slot;

    @Column(name = "sessionStart", nullable = false)
    private LocalDateTime sessionStart;

    @Column(name = "sessionEnd", nullable = false)
    private LocalDateTime sessionEnd;
}