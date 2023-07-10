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
@Table(name = "answer")
public class Answer extends BaseEntity {
    @Column(name = "questionId", nullable = false)
    private Long questionId;

    @Lob
    @Column(name = "answerDesc", nullable = false, length = -1)
    private String answerDesc;

    @Column(name = "answerScore", nullable = false, precision = 0)
    private Double answerScore;

    @Column(name = "isCorrect", nullable = false)
    private Boolean isCorrect;
}