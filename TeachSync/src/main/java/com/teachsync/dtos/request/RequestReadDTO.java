package com.teachsync.dtos.request;

import com.teachsync.entities.BaseEntity;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestReadDTO {
    private Long id;

    private Long requesterId;

    private String requestName;

    private String requestDesc;

    private String requestType;

    private Long clazzId;

    private byte[] requestContent;

    private String contentLink;

    private Long resolverId;

    private Status status;
}