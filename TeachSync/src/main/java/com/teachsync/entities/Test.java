package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
@Table(name = "test")
public class Test {
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "courseId")
    private Long courseId;
    @Column(name = "testName")
    private String testName;
    @Column(name = "testType")
    private String testType;
    @Column(name = "testImg")
    private String testImg;
    @Column(name = "testDesc")
    private String testDesc;
    @Column(name = "timeLimit")
    private int timeLimit;
    @Column(name = "numQuestion")
    private int numQuestion;
    @Column(name = "minScore")
    private float minScore;
    @Column(name = "testWeight")
    private int testWeight;
    @Column(name = "totalScore")
    private float totalScore;
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
