package com.teachsync.dtos.request;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestUpdateDTO {
    private Long id;

    private Long requesterId;

    private String requestName;

    @Lob
    private String requestDesc;

    private String requestType;

    private Long clazzId;

    private byte[] requestContent;

    @Lob
    private String contentLink;

    private Long resolverId;

    private Status status = Status.UPDATED;
}