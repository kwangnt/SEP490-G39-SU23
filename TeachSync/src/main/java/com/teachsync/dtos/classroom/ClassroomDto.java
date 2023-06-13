package com.teachsync.dtos.classroom;

import com.teachsync.entities.*;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    public static ClassroomDto toClassroomDto(Classroom classroom){
        return ClassroomDto.builder()
                .id(classroom.getId())
                .course(classroom.getCourse())
                .courseId(classroom.getCourseId())
                .className(classroom.getClassName())
                .classDesc(classroom.getClassDesc())
                .status(classroom.getStatus())
                .build();
    }

}
