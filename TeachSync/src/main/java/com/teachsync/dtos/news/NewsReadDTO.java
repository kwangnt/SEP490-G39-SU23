package com.teachsync.dtos.news;

import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.teachsync.entities.News}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsReadDTO implements Serializable {
    private Long id;

    private String newsTitle;

    private String newsDesc;

    private String newsLink;

    private User author;

    private Long authorId;

    private Status status;
}
