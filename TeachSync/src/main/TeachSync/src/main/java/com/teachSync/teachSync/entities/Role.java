package com.teachSync.teachSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "roleName")
    private String roleName;

    @Basic
    @Column(name = "roleDesc")
    private String roleDesc;

    @Basic
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> userList;
}
