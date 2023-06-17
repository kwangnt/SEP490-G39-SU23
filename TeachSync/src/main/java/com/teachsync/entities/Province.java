package com.teachsync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "province")
public class Province extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryId", referencedColumnName = "id", nullable = false)
    private Country country;
    @Column(name = "countryId", insertable = false, updatable = false)
    private Long countryId;
    
    @Column(name = "provinceName")
    private String provinceName;
}
