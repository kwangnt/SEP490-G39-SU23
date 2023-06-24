package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ward extends BaseEntity {
    @Column(name = "districtId", nullable = false)
    private Long districtId;
    
    @Column(name = "wardName", nullable = false, length = 255)
    private String wardName;
    
    @Column(name = "wardAlias", nullable = false, length = 45)
    private String wardAlias;
}