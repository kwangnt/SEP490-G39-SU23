package com.teachsync.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teachsync.utils.enums.Status;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class BaseCreateDTO implements Serializable {
    @JsonIgnore /* No serialize/deserialize */
    private Status status = Status.CREATED;

    @JsonIgnore /* No serialize/deserialize */
    private Long createdBy = null;

    @JsonIgnore /* No serialize/deserialize */
    private final LocalDateTime createdAt = LocalDateTime.now();
}
