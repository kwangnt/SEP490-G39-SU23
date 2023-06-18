package com.teachsync.dtos.request;


import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDto {

    private Long id;

    private User User;

    private String requestName;

    private String requestType;

    private String requestContent;

    private String contentLink;

    private String requestDesc;

    private Status status;
}
