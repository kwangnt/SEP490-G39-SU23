package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "certificate")
public class Certificate extends BaseEntity {
    @Column(name = "courseId", nullable = false)
    private Long courseId;

    @Column(name = "certificateName", nullable = false, length = 45)
    private String certificateName;

    @Lob
    @Column(name = "certificateDesc", nullable = true, length = -1)
    private String certificateDesc;

    @Lob
    @Column(name = "certificateImg", nullable = true, length = -1)
    private String certificateImg;

    @Lob
    @Column(name = "certificateLink", nullable = true, length = -1)
    private String certificateLink;

    @Column(name = "certificateContent", nullable = true)
    private byte[] certificateContent;
}