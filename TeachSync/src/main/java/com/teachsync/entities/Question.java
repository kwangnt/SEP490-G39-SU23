package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "questionType")
    private String questionType;
    @Column(name = "questionDesc")
    private String questionDesc;
    @Column(name = "questionPrompt")
    private String questionPrompt;
    @Column(name = "status")
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
