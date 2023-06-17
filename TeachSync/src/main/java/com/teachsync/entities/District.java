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
@Table(name = "district")
public class District extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cityId", referencedColumnName = "id", nullable = false)
    private City city;
    @Column(name = "cityId", insertable = false, updatable = false)
    private Long cityId;

    @Column(name = "districtName")
    private String districtName;
}
