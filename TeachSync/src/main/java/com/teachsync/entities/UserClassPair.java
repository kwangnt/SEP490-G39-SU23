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
@Table(name = "user_class_pair")
public class UserClassPair extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Positive
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classId", referencedColumnName = "id", nullable = false)
    private Clazz clazz;
    @Positive
    @Column(name = "classId", insertable = false, updatable = false)
    private Long classId;
}
