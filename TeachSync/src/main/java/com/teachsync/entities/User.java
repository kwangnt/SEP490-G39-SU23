package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User extends BaseEntity {
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    @Column(name = "roleId", nullable = false)
    private Long roleId;

    @Lob
    @Column(name = "userAvatar", nullable = true, length = -1)
    private String userAvatar;
    
    @Column(name = "fullName", nullable = false, length = 255)
    private String fullName;
    
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    
    @Column(name = "phone", nullable = true, length = 10)
    private String phone;
    
    @Column(name = "addressId", nullable = true)
    private Long addressId;
    
    @Column(name = "resetPasswordToken", nullable = true, length = 255)
    private String resetPasswordToken;
    
    @Column(name = "parentId", nullable = true)
    private Long parentId;
}