package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(name = "addressNo", nullable = false, length = 45)
    private String addressNo;

    @Column(name = "street", nullable = false, length = 255)
    private String street;

    @Column(name = "unitId", nullable = false)
    private Long unitId;

    /** Need to auto generate on Address Create & Update.<br/>
     *  To save on query call. */
    @Lob
    @Column(name = "addressString", nullable = true, length = -1)
    private String addressString;
}