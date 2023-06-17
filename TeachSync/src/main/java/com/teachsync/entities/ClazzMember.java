package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clazz_member")
public class ClazzMember extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Positive
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clazzId", referencedColumnName = "id", nullable = false)
    private Clazz clazz;
    @Positive
    @Column(name = "clazzId", insertable = false, updatable = false)
    private Long clazzId;
}
