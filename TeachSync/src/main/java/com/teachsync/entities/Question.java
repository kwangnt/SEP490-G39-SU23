package com.teachsync.entities;

import com.teachsync.utils.enums.QuestionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Table(name = "question")
public class Question extends BaseEntity {
    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "questionPrompt", length = 45)
    private String questionPrompt;

    @Lob
    @NotBlank
    @Column(name = "questionDesc")
    private String questionDesc;

    @NotNull
    @Column(name = "questionType", nullable = false)
    private QuestionType questionType;
}
