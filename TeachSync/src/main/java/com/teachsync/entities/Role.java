package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "roleName", length = 45)
    private String roleName;

    @Lob
    @Column(name = "roleDesc")
    private String roleDesc;
}
