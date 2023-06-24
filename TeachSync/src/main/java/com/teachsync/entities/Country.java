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
public class Country extends BaseEntity {
    @Column(name = "countryName", nullable = false, length = 255)
    private String countryName;
    
    @Column(name = "countryAlias", nullable = false, length = 45)
    private String countryAlias;
}