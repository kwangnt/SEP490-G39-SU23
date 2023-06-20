package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "answer")
public class Answer {
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "questionId", nullable = false)
    private Long questionId;
    @Column(name = "answerDesc", nullable = false)
    private String answerDesc;
    @Column(name = "isCorrect", nullable = false)
    private boolean isCorrect;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "createdBy")
    private Long createdBy;
    @Column(name = "updatedAt")
    private Date updatedAt;
    @Column(name = "updatedBy")
    private Long updatedBy;

}
