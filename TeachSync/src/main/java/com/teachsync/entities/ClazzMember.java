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
@Table(name = "clazz_member")
public class ClazzMember extends BaseEntity {
    @Column(name = "clazzId", nullable = false)
    private Long clazzId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "score", nullable = true, precision = 0)
    private Double score;

    /** In Percent '%', max 100% */
    @Column(name = "attendant", nullable = true, precision = 0)
    private Double attendant;

    @Column(name = "isPassed", nullable = true)
    private Boolean isPassed;
}