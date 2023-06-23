package com.teachsync.dtos.course;

import com.teachsync.dtos.priceLog.PriceLogReadDTO;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.Course;
import com.teachsync.entities.Material;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.Column;
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
    private String courseImg;

    private String courseDesc;

    private Double minScore;

    private Double minAttendant;

    private Status status;

    private List<Clazz> clazzList;

    private List<Material> materialList;

//    private List<PriceLog> priceLogList;
    private PriceLogReadDTO currentPrice;
}

