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
public class District extends BaseEntity {
    @Column(name = "cityId", nullable = false)
    private Long cityId;
    
    @Column(name = "districtName", nullable = false, length = 255)
    private String districtName;
    
    @Column(name = "districtAlias", nullable = false, length = 45)
    private String districtAlias;
}