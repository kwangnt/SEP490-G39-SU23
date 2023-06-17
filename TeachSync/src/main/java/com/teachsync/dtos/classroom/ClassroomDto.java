package com.teachsync.dtos.classroom;

import com.teachsync.entities.*;
import com.teachsync.utils.enums.Status;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClassroomDto {
    private Long id;

    private Course course;

    private Long courseId;

    private String className;

    private String classDesc;

    private Status status;

    private List<Homework> homeworkList;

    private List<Schedule> scheduleList;

    private List<Test> testList;

    public static ClassroomDto toClassroomDto(Clazz clazz){
        return ClassroomDto.builder()
                .id(clazz.getId())
                .course(clazz.getCourse())
                .courseId(clazz.getCourseId())
                .className(clazz.getClazzName())
                .classDesc(clazz.getClazzDesc())
                .status(clazz.getStatus())
                .build();
    }

}
