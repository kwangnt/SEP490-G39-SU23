package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Answer extends BaseEntity {
    @Column(name = "questionId", nullable = false)
    private Long questionId;

    @Lob
    @Column(name = "answerDesc", nullable = false, length = -1)
    private String answerDesc;

    @Column(name = "isCorrect", nullable = false)
    private Boolean isCorrect;
}
