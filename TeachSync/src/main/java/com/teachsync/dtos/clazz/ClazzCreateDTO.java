package com.teachsync.dtos.clazz;

import com.teachsync.entities.ClazzTest;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.entities.Homework;
import com.teachsync.entities.Session;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClazzCreateDTO {
    private Long courseId;

    private Long courseScheduleId;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Status status = Status.CREATED;
}