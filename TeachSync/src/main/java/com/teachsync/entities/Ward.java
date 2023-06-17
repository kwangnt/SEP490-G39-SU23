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
@Table(name = "ward")
public class Ward extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "districtId", referencedColumnName = "id", nullable = false)
    private District district;
    @Column(name = "districtId", insertable = false, updatable = false)
    private Long districtId;
    
    @Column(name = "wardName")
    private String wardName;
}
