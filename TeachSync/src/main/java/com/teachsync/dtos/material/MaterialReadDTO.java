package com.teachsync.dtos.material;

import com.teachsync.entities.Course;
import com.teachsync.utils.enums.Status;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MaterialReadDTO implements Serializable {
    private Long id;

    private Course course;

    private Long courseId;

    private String materialLink;

    private Status status;
}
