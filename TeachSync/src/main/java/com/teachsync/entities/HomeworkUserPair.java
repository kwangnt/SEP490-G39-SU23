package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
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
@Table(name = "homework_user_pair")
public class HomeworkUserPair {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homeworkId", referencedColumnName = "id", nullable = false)
    private Homework homework;
    @Basic
    @Column(name = "homeworkId", insertable = false, updatable = false)
    private Long homeworkId;

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
    private Status status;
}
