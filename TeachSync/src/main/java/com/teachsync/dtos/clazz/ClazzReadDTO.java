package com.teachsync.dtos.clazz;

import com.teachsync.entities.*;
import com.teachsync.utils.enums.Status;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClazzReadDTO {
    private Long id;

    private CourseSchedule courseSchedule;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Status status;

    private List<Homework> homeworkList;
    private List<ClazzTest> testList;

    private List<Session> sessionList;
}