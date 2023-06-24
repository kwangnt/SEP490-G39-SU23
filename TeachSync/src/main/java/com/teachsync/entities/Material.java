package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Material extends BaseEntity {
    @Column(name = "courseId", nullable = true)
    private Long courseId;
    
    @Column(name = "materialName", nullable = false, length = 45)
    private String materialName;

    @Lob
    @Column(name = "materialLink", nullable = true, length = -1)
    private String materialLink;
    
    @Column(name = "materialContent", nullable = true)
    private byte[] materialContent;

    @Lob
    @Column(name = "materialImg", nullable = false, length = -1)
    private String materialImg;
}