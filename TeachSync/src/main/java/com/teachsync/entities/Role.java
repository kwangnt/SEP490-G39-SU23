package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Role extends BaseEntity {
    @Column(name = "roleName", nullable = false, length = 45)
    private String roleName;

    @Lob
    @Column(name = "roleDesc", nullable = true, length = -1)
    private String roleDesc;
}