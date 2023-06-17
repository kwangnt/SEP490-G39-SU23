package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "member_homework_record")
public class MemberHomeworkRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homeworkId", referencedColumnName = "id", nullable = false)
    private Homework homework;
    @Positive
    @Column(name = "homeworkId", insertable = false, updatable = false)
    private Long homeworkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    private ClazzMember clazzMember;
    @Positive
    @Column(name = "memberId", insertable = false, updatable = false)
    private Long memberId;

    /* TODO: file or link */
    @Lob
    @Column(name = "submission")
    private String submission;

    @URL
    @Column(name = "submissionLink")
    private String submissionLink;
    
//    @Digits(integer = 2, fraction = 2)
//    @PositiveOrZero
//    @Range(min = 0, max = 10)
    @Column(name = "score")
    private Double score;
}
