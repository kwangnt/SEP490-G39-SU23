package com.teachsync.dtos.role;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class RoleUpdateDTO implements Serializable {
    @NotNull
    @Positive
    private Long id;

    @NotBlank
    @Size(min = 1, max = 45)
    private String roleName;

    @Lob
    private String roleDesc;

    private Status status = Status.UPDATED;
}
