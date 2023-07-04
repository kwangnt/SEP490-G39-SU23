package com.teachsync.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Clazz extends BaseEntity {
    @Column(name = "courseSemesterId", nullable = false)
    private Long courseSemesterId;
    
    @Column(name = "clazzName", nullable = false, length = 45)
    private String clazzName;

    @Lob
    @Column(name = "clazzDesc", nullable = true, length = -1)
    private String clazzDesc;
    
    @Column(name = "clazzSize", nullable = false)
    private Integer clazzSize;
}