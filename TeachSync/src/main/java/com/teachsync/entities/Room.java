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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room extends BaseEntity {
    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "roomName", length = 45)
    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "centerId", referencedColumnName = "id", nullable = false)
    private Center center;
    @Column(name = "center_id", insertable = false, updatable = false)
    private Long centerId;

    @Lob
    @Column(name = "roomDesc")
    private String roomDesc;

    @Column(name = "roomType", length = 45)
    private String roomType;

    /** Max number of people, not m2 */
    @NotNull
    @Positive
    @Column(name = "roomSize")
    private Integer roomSize;

}
