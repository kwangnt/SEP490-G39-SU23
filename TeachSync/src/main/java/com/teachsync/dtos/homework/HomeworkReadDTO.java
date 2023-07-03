package com.teachsync.dtos.homework;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkReadDTO extends BaseReadDTO {

    private Long clazzId;

    private String homeworkName;

    private String homeworkDesc;

    private String homeworkDoc;

    private String homeworkDocLink;

    private LocalDateTime deadline;

    private String clazzName;

}