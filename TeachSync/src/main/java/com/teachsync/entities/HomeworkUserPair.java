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
@Table(name = "homework_user_pair")
public class HomeworkUserPair extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homeworkId", referencedColumnName = "id", nullable = false)
    private Homework homework;
    @Positive
    @Column(name = "homeworkId", insertable = false, updatable = false)
    private Long homeworkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Positive
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;
    
//    @Digits(integer = 2, fraction = 2)
//    @PositiveOrZero
//    @Range(min = 0, max = 10)
    @Column(name = "score")
    private Double score;
}
