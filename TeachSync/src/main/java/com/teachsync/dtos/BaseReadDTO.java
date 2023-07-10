package com.teachsync.dtos;

import com.teachsync.utils.enums.Status;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class BaseReadDTO implements Serializable {
    private Long id;

    private Status status;

    private Long createdBy;
    private LocalDateTime createdAt;

    private Long updatedBy;
    private LocalDateTime updatedAt;
}
