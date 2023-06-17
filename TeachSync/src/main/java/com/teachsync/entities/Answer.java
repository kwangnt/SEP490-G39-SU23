package com.teachsync.entities;

import com.teachsync.utils.enums.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "answer")
public class Answer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "questionId", referencedColumnName = "id", nullable = false)
    private Question question;
    @Column(name = "questionId", insertable = false, updatable = false)
    private Long questionId;

    @Lob
    @NotBlank
    @Column(name = "answerDesc", nullable = false)
    private String answerDesc;

    @NotNull
    @Column(name = "isCorrect", nullable = false)
    private Boolean isCorrect = false;
}
