package com.teachsync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Certificate extends BaseEntity {
//    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
//    @JoinColumn(name = "courseId", nullable = false)
//    private Course course;
    @Column(name = "courseId", nullable = false)
    private Long courseId;
    
    @Column(name = "certificateName", nullable = false, length = 45)
    private String certificateName;

    @Lob
    @Column(name = "certificateDesc", nullable = true, length = -1)
    private String certificateDesc;
}