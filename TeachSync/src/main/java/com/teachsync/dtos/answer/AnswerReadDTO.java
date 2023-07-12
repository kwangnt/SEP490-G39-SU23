package com.teachsync.dtos.answer;

import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Answer}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerReadDTO extends BaseReadDTO {
    private Long questionId;
    private String answerDesc;
    private Double answerScore;
    private Boolean isCorrect;
}