package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Area extends BaseEntity {
    @Column(name = "wardId", nullable = false)
    private Long wardId;
    
    @Column(name = "areaName", nullable = false, length = 255)
    private String areaName;
    
    @Column(name = "areaAlias", nullable = false, length = 45)
    private String areaAlias;
}