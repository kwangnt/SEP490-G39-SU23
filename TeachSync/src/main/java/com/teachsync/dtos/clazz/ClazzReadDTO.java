package com.teachsync.dtos.clazz;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.clazzSchedule.ClazzScheduleReadDTO;
import com.teachsync.dtos.courseSchedule.CourseScheduleReadDTO;
import com.teachsync.entities.*;
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
    private String clazzName;

    private String clazzDesc;

    private int clazzSize;

    private Long courseScheduleId;
    private CourseScheduleReadDTO courseSchedule;

    private ClazzScheduleReadDTO clazzSchedule;

    private List<Session> sessionList;

    private List<ClazzMember> memberList;

    private List<Homework> homeworkList;

    private List<ClazzTest> testList;
}