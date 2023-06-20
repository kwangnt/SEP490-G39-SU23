package com.teachsync.dtos.request;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherApplicationRequestCreateDTO {
    /* Acc teacher */
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @NotBlank
    @Size(min = 1, max = 255)
    private String fullName;

    @Email
    @Size(min = 5, max = 255)
    private String email;

    @Size(min = 10, max = 10)
    private String phone;


    /* Teacher Application */

    /* Tạo cái acc teacher status = DELETED, xong lấy id nó bỏ vô đây */
    @Positive
    private Long requesterId;

    @NotBlank
    @Size(min = 1, max = 45)
    private String requestName;

    private String requestType = "APPLICATION"; /* TODO: enum */

    /* TODO: Chứa file nếu có thể */
    @Lob
    private String requestContent;

    /* Link drive chứa hồ sơ */
    @Lob
    @URL
    private String contentLink;

    /* Tự giới thiệu */
    @Lob
    private String requestDesc;

    private Status status = Status.CREATED;
}
