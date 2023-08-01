package com.teachsync.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "test_session")
public class TestSession {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "userid", nullable = false)
    private Long userId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "submit_date")
    private Long submitDate;

    @Column(name = "status")
    private int status;

    @Column(name = "update_date")
    private int updateDate;

}
