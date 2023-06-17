package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "center")
public class Center extends BaseEntity {
    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "centerName", length = 45)
    private String centerName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "addressId", referencedColumnName = "id", nullable = false)
    private Address address;
    @Column(name = "addressId", insertable = false, updatable = false)
    private Long addressId;

    @Lob
    @Column(name = "centerDesc")
    private String centerDesc;

    @Column(name = "centerType", length = 45)
    private String centerType;
    
    @NotNull
    @Positive
    @Column(name = "centerSize")
    private Integer centerSize;

}
