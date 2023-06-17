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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "news")
public class News extends BaseEntity {
    @Size(min = 1, max = 45)
    @NotBlank
    @Column(name = "newsTitle", nullable = false, length = 45)
    private String newsTitle;

    @Lob
    @NotBlank
    @Column(name = "newsDesc")
    private String newsDesc;

    @Lob
    @NotBlank
    @Column(name = "newsContent")
    private String newsContent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "authorId", referencedColumnName = "id", nullable = false)
    private User author;
    @Positive
    @Column(name = "authorId", insertable = false, updatable = false)
    private Long authorId;

    public News(String newsTitle, String newsDesc, String newsContent, User author, Long authorId, Status status) {
        super(null, status, null, null, null, null);
        this.newsTitle = newsTitle;
        this.newsDesc = newsDesc;
        this.newsContent = newsContent;
        this.author = author;
        this.authorId = authorId;
    }

    public News(Long id, String newsTitle, String newsDesc, String newsContent, User author, Long authorId, Status status) {
        super(id, status, null, null, null, null);
        this.newsTitle = newsTitle;
        this.newsDesc = newsDesc;
        this.newsContent = newsContent;
        this.author = author;
        this.authorId = authorId;
    }
}
