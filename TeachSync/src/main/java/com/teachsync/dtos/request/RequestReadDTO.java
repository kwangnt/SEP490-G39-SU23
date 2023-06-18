package com.teachsync.dtos.request;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestReadDTO {
    private Long id;

    private Long requesterId;

    private String requestName;

    private String requestType;

    private String requestContent;

    private String contentLink;

    private String requestDesc;

    private Long resolverId;

    private Status status;
}
