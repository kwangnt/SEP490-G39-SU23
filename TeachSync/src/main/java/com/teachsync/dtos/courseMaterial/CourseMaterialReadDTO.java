package com.teachsync.dtos.courseMaterial;

import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterialReadDTO extends BaseReadDTO {
    private Long courseId;

    private String courseName;

    private Long materialId;

    private String materialName;
}
