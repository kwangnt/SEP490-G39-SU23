package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Session extends BaseEntity {
    @Column(name = "roomId", nullable = false)
    private Long roomId;
    
    @Column(name = "scheduleId", nullable = false)
    private Long scheduleId;
    
    @Column(name = "teacherId", nullable = false)
    private Long teacherId;
    
    @Column(name = "slot", nullable = true)
    private Integer slot;

    @Column(name = "sessionStart", nullable = false)
    private LocalDateTime sessionStart;

    @Column(name = "sessionEnd", nullable = false)
    private LocalDateTime sessionEnd;
}