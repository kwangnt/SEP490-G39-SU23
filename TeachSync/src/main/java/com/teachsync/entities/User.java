package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
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
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
    private Role role;
    @Basic
    @Column(name = "roleId", insertable = false, updatable = false)
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private User parent;
    @Basic
    @Column(name = "parentId", insertable = false, updatable = false)
    private Long parentId;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<News> newsList;

    @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY)
    private List<Request> requestMadeList;

    @OneToMany(mappedBy = "resolver", fetch = FetchType.LAZY)
    private List<Request> requestResolvedList;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<User> childList;

    public User(String username, String password, String email, String fullName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = 1L;
        this.status = Status.CREATED;
    }
}
