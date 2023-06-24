package com.teachsync.dtos.clazz;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.entities.ClazzTest;
import com.teachsync.entities.CourseSchedule;
import com.teachsync.entities.Homework;
import com.teachsync.entities.Session;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.teachsync.entities.Clazz}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzReadDTO extends BaseReadDTO {
    private Long id;

    private CourseSchedule courseSchedule;

    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private List<Homework> homeworkList;
    private List<ClazzTest> testList;

    private List<Session> sessionList;

    private Status status;
    private Long createdBy;
    private LocalDateTime createdAt;
    private Long updatedBy;
    private LocalDateTime updatedAt;
}