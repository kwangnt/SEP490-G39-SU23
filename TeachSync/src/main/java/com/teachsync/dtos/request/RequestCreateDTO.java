package com.teachsync.dtos.request;

import com.teachsync.dtos.BaseCreateDTO;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Request}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateDTO extends BaseCreateDTO {
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

    private Status status = Status.CREATED;
}