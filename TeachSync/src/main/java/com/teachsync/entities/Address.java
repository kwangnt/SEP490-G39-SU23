package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Address extends BaseEntity {
    @Column(name = "countryId", nullable = false)
    private Long countryId;

    @Column(name = "provinceId", nullable = false)
    private Long provinceId;

    @Column(name = "cityId", nullable = false)
    private Long cityId;

    @Column(name = "districtId", nullable = false)
    private Long districtId;

    @Column(name = "wardId", nullable = false)
    private Long wardId;

    @Column(name = "areaId", nullable = true)
    private Long areaId;

    @Column(name = "street", nullable = false, length = 255)
    private String street;

    @Column(name = "addressNo", nullable = false, length = 255)
    private String addressNo;

    /** Need to auto generate on Address Create & Update.<br/>
     *  To save on query call. */
    @Lob
    @Column(name = "addressString", nullable = true, length = -1)
    private String addressString;
}
