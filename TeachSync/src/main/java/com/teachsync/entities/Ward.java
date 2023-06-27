package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Ward extends BaseEntity {
    @Column(name = "districtId", nullable = false)
    private Long districtId;
    
    @Column(name = "wardName", nullable = false, length = 255)
    private String wardName;
    
    @Column(name = "wardAlias", nullable = false, length = 45)
    private String wardAlias;
}