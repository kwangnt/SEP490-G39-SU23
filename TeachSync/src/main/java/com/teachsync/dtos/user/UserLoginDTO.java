package com.teachsync.dtos.user;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.entities.Request;
import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link User}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO implements Serializable {
    private String username;

    private String password;
}
