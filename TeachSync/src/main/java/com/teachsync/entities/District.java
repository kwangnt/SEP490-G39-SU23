package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class District extends BaseEntity {
    @Column(name = "cityId", nullable = false)
    private Long cityId;
    
    @Column(name = "districtName", nullable = false, length = 255)
    private String districtName;
    
    @Column(name = "districtAlias", nullable = false, length = 45)
    private String districtAlias;
}