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
public class Province extends BaseEntity {
    @Column(name = "countryId", nullable = false)
    private Long countryId;
    
    @Column(name = "provinceName", nullable = false, length = 255)
    private String provinceName;
    
    @Column(name = "provinceAlias", nullable = false, length = 45)
    private String provinceAlias;
}