package com.teachsync.dtos.homework;

import com.teachsync.dtos.BaseReadDTO;
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

    private byte[] homeworkContent;

    private LocalDateTime deadline;

    private LocalDateTime openAt;

    private String clazzName;

}