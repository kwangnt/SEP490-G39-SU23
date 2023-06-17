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
@Table(name = "test_record")
public class TestRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private MemberTestRecord memberTestRecord;
    @Positive
    @Column(name = "userId", insertable = false, updatable = false)
    private Long memberTestRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testQuestionId", referencedColumnName = "id", nullable = false)
    private TestQuestion testQuestion;
    @Positive
    @Column(name = "testQuestionId", insertable = false, updatable = false)
    private Long testQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answerId", referencedColumnName = "id", nullable = false)
    private Answer answer;
    @Positive
    @Column(name = "answerId", insertable = false, updatable = false)
    private Long answerId;
}
