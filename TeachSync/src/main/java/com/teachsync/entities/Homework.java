package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Homework extends BaseEntity {
    @Column(name = "clazzId", nullable = false)
    private Long clazzId;

    @Column(name = "homeworkName", nullable = false, length = 45)
    private String homeworkName;

    @Lob
    @Column(name = "homeworkDesc", nullable = true, length = -1)
    private String homeworkDesc;

    @Column(name = "homeworkDoc", nullable = true)
    private String homeworkDoc;

    @Lob
    @Column(name = "homeworkDocLink", nullable = true, length = -1)
    private String homeworkDocLink;

    @Column(name = "deadline")
    private LocalDateTime deadline;

    @Column(name = "openAt")
    private LocalDateTime openAt;
}