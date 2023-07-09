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
@Table(name = "clazz_test")
public class ClazzTest extends BaseEntity {
    @Column(name = "clazzId", nullable = false)
    private Long clazzId;

    @Column(name = "testId", nullable = false)
    private Long testId;

    @Column(name = "openFrom", nullable = true)
    private LocalDateTime openFrom;

    @Column(name = "openTo", nullable = true)
    private LocalDateTime openTo;
}