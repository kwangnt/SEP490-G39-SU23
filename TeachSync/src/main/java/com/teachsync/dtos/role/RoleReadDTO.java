package com.teachsync.dtos.role;

import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.teachsync.entities.Role}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleReadDTO implements Serializable {
    private Long id;

    private String roleName;

    private String roleDesc;

    private Status status;
}
