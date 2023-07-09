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
@Table(name = "staff")
public class Staff extends BaseEntity {
    @Column(name = "centerId", nullable = false)
    private Long centerId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    /** Employee position (Ex: Leader, Teacher, Dean,...) */
    @Column(name = "staffType", nullable = false, length = 45)
    private String staffType;
}