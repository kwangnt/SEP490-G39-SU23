package com.teachSync.teachSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "test_user_pair")
public class TestUserPair {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testId", referencedColumnName = "id", nullable = false)
    private Test test;
    @Basic
    @Column(name = "testId", insertable = false, updatable = false)
    private Long testId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @Basic
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;

    @Basic
    @Column(name = "score")
    private Double score;

    @Basic
    @Column(name = "status")
    private String status;
}
