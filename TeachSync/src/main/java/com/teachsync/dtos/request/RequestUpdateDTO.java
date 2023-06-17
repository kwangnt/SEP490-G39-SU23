package com.teachsync.dtos.request;

import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
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
public class RequestUpdateDTO {
    @Positive
    private Long id;

    /* Nullable */
    @Positive
    private Long requesterId;

    @NotBlank
    @Size(min = 1, max = 45)
    private String requestName;

    private String requestType;

    @Lob
    private String requestContent;

    @Lob
    @URL
    private String contentLink;

    @Lob
    private String requestDesc;

    @Positive
    private Long resolverId;

    private Status status = Status.UPDATED;
}
