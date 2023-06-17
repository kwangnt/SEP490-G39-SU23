package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
@Table(name = "test_question")
public class TestQuestion extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testId", referencedColumnName = "id", nullable = false)
    private Test test;
    @Positive
    @Column(name = "testId", insertable = false, updatable = false)
    private Long testId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "questionId", referencedColumnName = "id", nullable = false)
    private Question question;
    @Positive
    @Column(name = "questionId", insertable = false, updatable = false)
    private Long questionId;

    @Positive
    @Range(min = 0, max = 10)
//    @Digits(integer = 2, fraction = 2)
    @Column(name = "score")
    private Double score;
}
