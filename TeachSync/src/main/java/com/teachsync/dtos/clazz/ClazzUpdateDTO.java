package com.teachsync.dtos.clazz;

import com.teachsync.dtos.BaseUpdateDTO;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Clazz}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzUpdateDTO extends BaseUpdateDTO {
    private Long id;
    private Long courseId;

    private Long courseScheduleId;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Status status = Status.UPDATED;
}