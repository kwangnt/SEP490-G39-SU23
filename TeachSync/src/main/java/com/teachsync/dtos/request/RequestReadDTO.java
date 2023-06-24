package com.teachsync.dtos.request;

import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.teachsync.entities.Request}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestReadDTO implements Serializable {
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