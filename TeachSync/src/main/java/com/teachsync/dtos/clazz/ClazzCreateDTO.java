package com.teachsync.dtos.clazz;

import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.teachsync.entities.Clazz}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzCreateDTO implements Serializable {
    private Long courseId;

    private Long courseScheduleId;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Status status = Status.CREATED;
}