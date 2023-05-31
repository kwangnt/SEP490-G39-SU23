package com.teachsync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "price_log")
public class PriceLog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId", referencedColumnName = "id", nullable = false)
    private Course course;
    @Basic
    @Column(name = "courseId", insertable = false, updatable = false)
    private Long courseId;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "isCurrent")
    private Boolean isCurrent;

    @Basic
    @Column(name = "isPromotion")
    private Boolean isPromotion;

    @Basic
    @Column(name = "promotionType")
    private String promotionType;

    @Basic
    @Column(name = "promotionAmount")
    private String promotionAmount;

    @Basic
    @Column(name = "promotionDesc")
    private String promotionDesc;

    @Basic
    @Column(name = "validFrom")
    private Timestamp validFrom;

    @Basic
    @Column(name = "validTo")
    private Timestamp validTo;

    @Basic
    @Column(name = "status")
    private String status;
}
