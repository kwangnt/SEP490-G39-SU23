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
@Table(name = "room")
public class Room extends BaseEntity {
    @Column(name = "centerId", nullable = false)
    private Long centerId;

    @Column(name = "roomType", nullable = true, length = 45)
    private String roomType;

    @Lob
    @Column(name = "roomDesc", nullable = true, length = -1)
    private String roomDesc;

    @Column(name = "roomName", nullable = true, length = 45)
    private String roomName;

    @Column(name = "roomSize", nullable = false)
    private Integer roomSize;
}