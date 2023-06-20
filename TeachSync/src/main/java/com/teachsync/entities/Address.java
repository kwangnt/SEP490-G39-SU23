package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id" )
    private Long id;

    @Column(name = "countryId")
    private Long countryId;

    @Column(name = "provinceId")
    private Long provinceId;

    @Column(name = "cityId")
    private Long cityId;

    @Column(name = "districtId")
    private Long districtId;

    @Column(name = "wardId")
    private Long wardId;

    @Column(name = "areaId")
    private Long areaId;

    @Column(name = "street")
    private String street;

    @Column(name = "addressNo")
    private String addressNo;

    @Column(name = "status")
    private Status status;
}
