package com.teachsync.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teachsync.utils.enums.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class BaseUpdateDTO implements Serializable {
    @Positive
    private Long id;

    private Status status = Status.UPDATED;

    @JsonIgnore /* No serialize/deserialize */
    private Long updatedBy = null;

    @JsonIgnore /* No serialize/deserialize */
    private final LocalDateTime updatedAt = LocalDateTime.now();
}
