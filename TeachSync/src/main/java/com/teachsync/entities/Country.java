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
public class Country extends BaseEntity {
    @Column(name = "countryName", nullable = false, length = 255)
    private String countryName;
    
    @Column(name = "countryAlias", nullable = false, length = 45)
    private String countryAlias;
}