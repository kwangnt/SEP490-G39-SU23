package com.teachsync.dtos.course;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.dtos.priceLog.PriceLogReadDTO;
import com.teachsync.entities.Clazz;
import com.teachsync.entities.Material;
import com.teachsync.utils.enums.Status;
import lombok.*;

import java.util.List;

/**
 * DTO for {@link com.teachsync.entities.Course}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReadDTO extends BaseReadDTO {
    private String courseName;
    private String courseImg;

    private String courseDesc;

    private Double minScore;

    private Double minAttendant;

    private List<Clazz> clazzList;

    private List<Material> materialList;

//    private List<PriceLog> priceLogList;
    private PriceLogReadDTO currentPrice;
}

