package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class News extends BaseEntity {
    @Column(name = "authorId", nullable = false)
    private Long authorId;
    
    @Column(name = "newsTitle", nullable = false, length = 45)
    private String newsTitle;
    
    @Column(name = "newsContent", nullable = true)
    private byte[] newsContent;

    @Lob
    @Column(name = "newsLink", nullable = true, length = -1)
    private String newsLink;

    @Lob
    @Column(name = "newsDesc", nullable = true, length = -1)
    private String newsDesc;
}