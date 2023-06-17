package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = false, length = 45)
    private Status status;

    @Positive
    @Column(name = "createdBy")
    private Long createdBy;
    @Positive
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Positive
    @Column(name = "updatedBy")
    private Long updatedBy;
    @Positive
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
}
