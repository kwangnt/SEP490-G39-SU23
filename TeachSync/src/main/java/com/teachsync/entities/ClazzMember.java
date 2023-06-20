package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clazz_member", schema = "teachsync")
public class ClazzMember extends BaseEntity {
    @Column(name = "clazzId", nullable = false)
    private Long clazzId;
    
    @Column(name = "userId", nullable = false)
    private Long userId;
    
    @Column(name = "memberRole", nullable = false, length = 45)
    private String memberRole;
    
    @Column(name = "score", nullable = true, precision = 0)
    private Double score;
    
    @Column(name = "attendant", nullable = true, precision = 0)
    private Double attendant;
    
    @Column(name = "isPassed", nullable = true)
    private Boolean isPassed;
}