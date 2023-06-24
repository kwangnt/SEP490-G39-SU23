package com.teachsync.dtos.role;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.teachsync.entities.Role}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleReadDTO extends BaseReadDTO {
    private Long id;

    private String roleName;

    private String roleDesc;

    private Status status;
}
