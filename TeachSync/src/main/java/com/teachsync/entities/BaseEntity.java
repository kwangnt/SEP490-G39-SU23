package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {@Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = false, length = 45)
    private Status status;

    @Positive
    @Column(name = "createdBy")
    private Long createdBy;

    @Column(name = "createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Positive
    @Column(name = "updatedBy")
    private Long updatedBy;
    @Column(name = "updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt ;
}
