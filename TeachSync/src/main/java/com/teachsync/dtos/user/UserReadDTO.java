package com.teachsync.dtos.user;

import com.teachsync.entities.Request;
import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.teachsync.entities.User}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDTO implements Serializable {
    private Long id;

    private Long roleId;

    private Long parentId;

    private String username;

    /* NEVER SHOW PASSWORD */

    private String fullName;

    private String email;

    private String phone;

    private String address;

    private Status status;

    private List<Request> requestMadeList;

    private List<User> childList;
}
