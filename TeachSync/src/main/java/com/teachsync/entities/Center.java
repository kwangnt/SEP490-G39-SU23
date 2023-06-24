package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Center extends BaseEntity {
    @Column(name = "addressId", nullable = false)
    private Long addressId;
    
    @Column(name = "centerName", nullable = false, length = 45)
    private String centerName;
    
    @Column(name = "centerType", nullable = false, length = 45)
    private String centerType;

    @Lob
    @Column(name = "centerDesc", nullable = true, length = -1)
    private String centerDesc;

    /** Number of room */
    @Column(name = "centerSize", nullable = false)
    private Integer centerSize;
}