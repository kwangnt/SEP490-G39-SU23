package com.teachsync.dtos.clazz;

import com.teachsync.dtos.BaseUpdateDTO;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Clazz}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzUpdateDTO extends BaseUpdateDTO {
    private Long id;
    private Long courseId;

    private Long courseSemesterId;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Status status = Status.UPDATED;
}