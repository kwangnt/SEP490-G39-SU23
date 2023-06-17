package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
@Table(name = "user")
public class User extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
    private Role role;
    @Positive
    @Column(name = "roleId", insertable = false, updatable = false)
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private User parent;
    @Positive
    @Column(name = "parentId", insertable = false, updatable = false)
    private Long parentId;

    @NotBlank
    @Size(min = 4, max = 45)
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "fullName")
    private String fullName;

    @Email
    @Size(min = 5, max = 255)
    @Column(name = "email")
    private String email;

//    @Pattern(regexp = "^\\\\d{10}$")
    @Size(min = 10, max = 10)
    @Column(name = "phone", length = 10)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;
    @Positive
    @Column(name = "addressId", insertable = false, updatable = false)
    private Long addressId;

    @Column(name = "resetPasswordToken")
    private String resetPasswordToken;
}
