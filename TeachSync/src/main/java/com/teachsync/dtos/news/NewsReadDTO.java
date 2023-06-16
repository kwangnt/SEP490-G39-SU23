package com.teachsync.dtos.news;

import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewsReadDTO implements Serializable {
    private Long id;

    private String newsTitle;

    private String newsDesc;

    private String newsLink;

    private User author;

    private Long authorId;

    private Status status;
}
