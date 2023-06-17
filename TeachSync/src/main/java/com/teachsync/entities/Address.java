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
@Table(name = "address")
public class Address extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryId", referencedColumnName = "id", nullable = false)
    private Country country;
    @Column(name = "countryId", insertable = false, updatable = false)
    private Long countryId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provinceId", referencedColumnName = "id", nullable = false)
    private Province province;
    @Column(name = "provinceId", insertable = false, updatable = false)
    private Long provinceId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cityId", referencedColumnName = "id", nullable = false)
    private City city;
    @Column(name = "cityId", insertable = false, updatable = false)
    private Long cityId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "districtId", referencedColumnName = "id", nullable = false)
    private District district;
    @Column(name = "districtId", insertable = false, updatable = false)
    private Long districtId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wardId", referencedColumnName = "id", nullable = false)
    private Ward ward;
    @Column(name = "wardId", insertable = false, updatable = false)
    private Long wardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areaId", referencedColumnName = "id")
    private Area area;
    @Column(name = "areaId", insertable = false, updatable = false)
    private Long areaId;

    @Column(name = "street")
    private String street;

    @Column(name = "addressNo")
    private String addressNo;
}
