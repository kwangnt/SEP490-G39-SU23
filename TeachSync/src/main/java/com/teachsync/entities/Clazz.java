package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Clazz extends BaseEntity {
    @Column(name = "courseScheduleId", nullable = false)
    private Long courseScheduleId;
    
    @Column(name = "clazzName", nullable = false, length = 45)
    private String clazzName;

    @Lob
    @Column(name = "clazzDesc", nullable = true, length = -1)
    private String clazzDesc;
    
    @Column(name = "clazzSize", nullable = false)
    private Integer clazzSize;
}