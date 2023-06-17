package com.teachsync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "city")
public class City extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provinceId", referencedColumnName = "id", nullable = false)
    private Province provinceByProvinceId;
    @Column(name = "provinceId", insertable = false, updatable = false)
    private Long provinceId;

    @Column(name = "cityName")
    private String cityName;
}
