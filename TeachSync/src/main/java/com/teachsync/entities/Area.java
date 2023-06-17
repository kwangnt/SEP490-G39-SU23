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
@Table(name = "area")
public class Area extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wardId", referencedColumnName = "id", nullable = false)
    private Ward ward;
    @Column(name = "wardId", insertable = false, updatable = false)
    private Long wardId;
    
    @Column(name = "areaName")
    private String areaName;
}
