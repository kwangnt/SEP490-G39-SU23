package com.teachsync.dtos.clazz;

import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClazzUpdateDTO {
    private Long id;
    private Long courseId;

    private Long courseScheduleId;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Status status = Status.UPDATED;
}