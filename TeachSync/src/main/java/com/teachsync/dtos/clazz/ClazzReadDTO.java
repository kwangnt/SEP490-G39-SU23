package com.teachsync.dtos.clazz;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.clazzSchedule.ClazzScheduleReadDTO;
import com.teachsync.dtos.courseSemester.CourseSemesterReadDTO;
import com.teachsync.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    private Long courseSemesterId;
    private CourseSemesterReadDTO courseSemester;

    private ClazzScheduleReadDTO clazzSchedule;

    private List<Session> sessionList;

    private List<ClazzMember> memberList;

    private List<Homework> homeworkList;

    private List<ClazzTest> testList;
}