package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "member_test_record")
public class MemberTestRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testId", referencedColumnName = "id", nullable = false)
    private Test test;
    @Positive
    @Column(name = "testId", insertable = false, updatable = false)
    private Long testId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    private ClazzMember clazzMember;
    @Positive
    @Column(name = "memberId", insertable = false, updatable = false)
    private Long memberId;

    @PositiveOrZero
    @Range(min = 0, max = 10)
//    @Digits(integer = 2, fraction = 2)
    @Column(name = "score")
    private Double score;
}
