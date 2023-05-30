package com.teachSync.teachSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "request")
public class Request {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requesterId", referencedColumnName = "id", nullable = false)
    private User requester;
    @Basic
    @Column(name = "requesterId", insertable = false, updatable = false)
    private Long requesterId;

    @Basic
    @Column(name = "requestName")
    private String requestName;

    @Basic
    @Column(name = "requestType")
    private String requestType;

    @Basic
    @Column(name = "requestDesc")
    private String requestDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resolverId", referencedColumnName = "id")
    private User resolver;
    @Basic
    @Column(name = "resolverId", insertable = false, updatable = false)
    private Long resolverId;

    @Basic
    @Column(name = "status")
    private String status;
}
