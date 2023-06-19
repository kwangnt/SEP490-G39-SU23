package com.teachsync.entities;

import com.teachsync.utils.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Entity
@Data
@Table(name = "teacher_request")
public class TeacherRequest {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", columnDefinition = "long")
    private User User;

    @Column(name = "requestName")
    private String requestName;

    @Column(name = "requestType")
    private String requestType;

    @Column(name = "requestContent")
    private String requestContent;

    @Column(name = "contentLink")
    private String contentLink;

    @Column(name = "requestDesc")
    private String requestDesc;

    @Column(name = "status")
    private Status status;
}
