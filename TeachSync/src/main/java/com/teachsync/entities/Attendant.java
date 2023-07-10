package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "attendant")
public class Attendant extends BaseEntity {
    @Column(name = "sessionId", nullable = false)
    private Long sessionId;

    @Column(name = "memberId", nullable = false)
    private Long memberId;

    @Column(name = "isPresent", nullable = false)
    private Boolean isPresent;
}