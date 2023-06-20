package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Attendant extends BaseEntity {
    @Column(name = "sessionId", nullable = false)
    private Long sessionId;
    
    @Column(name = "memberId", nullable = false)
    private Long memberId;
    
    @Column(name = "isPresent", nullable = false)
    private Boolean isPresent;
}