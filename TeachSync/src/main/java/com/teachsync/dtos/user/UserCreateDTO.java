package com.teachsync.dtos.user;

import com.teachsync.dtos.BaseCreateDTO;
import com.teachsync.utils.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.User}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO extends BaseCreateDTO {
    @Positive
    private Long roleId;

    @Positive
    private Long parentId;

    @NotBlank
    @Size(min = 4, max = 45)
    private String username;

    @NotBlank
    @Size(min = 1, max = 255)
    private String password;

    @NotBlank
    @Size(min = 1, max = 255)
    private String fullName;

    @Email
    @Size(min = 5, max = 255)
    private String email;

//    @Pattern(regexp = "^\\\\d{10}$")
    @Size(min = 10, max = 10)
    private String phone;

    @Size(min = 5, max = 255)
    private String address;

    private Status status = Status.CREATED;

    @Email
    @Size(min = 5, max = 255)
    private String parentEmail;


    /** For Student signup */
    public UserCreateDTO(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.roleId = 1L;
    }
}
