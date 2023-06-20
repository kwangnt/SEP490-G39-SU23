package com.teachsync.dtos.course;

import com.teachsync.dtos.priceLog.PriceLogReadDTO;
import com.teachsync.entities.Classroom;
import com.teachsync.entities.Course;
import com.teachsync.entities.Material;
import com.teachsync.utils.enums.Status;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CourseReadDTO implements Serializable {
    private Long id;

    private String courseName;

    private String courseDesc;

    private Status status;

    private List<Classroom> classroomList;

    private List<Material> materialList;

    //    private List<PriceLog> priceLogList;
    private PriceLogReadDTO currentPrice;

    public static CourseReadDTO toCourseReadDTO(Course course) {
        return CourseReadDTO.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseDesc(course.getCourseDesc())
                .status(course.getStatus())
                .classroomList(course.getClassroomList())
                .materialList(course.getMaterialList())
                .build();
    }

}

