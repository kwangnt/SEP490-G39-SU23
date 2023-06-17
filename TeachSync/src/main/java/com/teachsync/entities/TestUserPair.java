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
@Table(name = "test_user_pair")
public class TestUserPair extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testId", referencedColumnName = "id", nullable = false)
    private Test test;
    @Positive
    @Column(name = "testId", insertable = false, updatable = false)
    private Long testId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Positive
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;

//    @PositiveOrZero
//    @Range(min = 0, max = 10)
//    @Digits(integer = 2, fraction = 2)
    @Column(name = "score")
    private Double score;
}
