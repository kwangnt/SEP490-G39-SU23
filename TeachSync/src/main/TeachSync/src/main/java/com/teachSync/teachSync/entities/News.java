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
@Table(name = "news")
public class News {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "newsTitle")
    private String newsTitle;

    @Basic
    @Column(name = "newsDesc")
    private String newsDesc;

    @Basic
    @Column(name = "newsLink")
    private String newsLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId", referencedColumnName = "id", nullable = false)
    private User author;
    @Basic
    @Column(name = "authorId", insertable = false, updatable = false)
    private Long authorId;

    @Basic
    @Column(name = "status")
    private String status;
}
