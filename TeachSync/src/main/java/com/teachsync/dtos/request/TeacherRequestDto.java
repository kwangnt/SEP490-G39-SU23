package com.teachsync.dtos.request;


import com.teachsync.entities.TeacherRequest;
import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherRequestDto {

    private Long id;

    private User user;

    private String requestName;

    private String requestType;

    private String requestContent;

    private String contentLink;

    private String requestDesc;

    private Status status;

    public static TeacherRequestDto toTeacherRequestDto(TeacherRequest teacherRequest) {
        return TeacherRequestDto.builder()
                .id(teacherRequest.getId())
                .user(teacherRequest.getUser())
                .requestName(teacherRequest.getRequestName())
                .requestType(teacherRequest.getRequestType())
                .requestContent(teacherRequest.getRequestContent())
                .contentLink(teacherRequest.getContentLink())
                .requestDesc(teacherRequest.getRequestDesc())
                .status(teacherRequest.getStatus())
                .build();
    }
}
