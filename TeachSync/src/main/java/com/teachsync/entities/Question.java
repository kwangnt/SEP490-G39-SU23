package com.teachsync.entities;

import com.teachsync.utils.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "question")
public class Question extends BaseEntity {
    @Column(name = "testId")
    private Long testId;

    @Column(name = "questionType", nullable = false, length = 255)
    private QuestionType questionType;

    @Lob
    @Column(name = "questionDesc", nullable = false, length = -1)
    private String questionDesc;

    @Column(name = "questionPrompt", nullable = false, length = 45)
    private String questionPrompt;
}
