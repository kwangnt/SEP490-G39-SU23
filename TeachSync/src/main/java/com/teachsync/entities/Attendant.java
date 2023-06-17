package com.teachsync.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attendant")
public class Attendant extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sessionId", referencedColumnName = "id", nullable = false)
    private Session session;
    @Column(name = "sessionId", insertable = false, updatable = false)
    private Long sessionId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    private ClazzMember clazzMember;
    @Column(name = "memberId", insertable = false, updatable = false)
    private Long memberId;

    @Column(name = "isPresent", nullable = false)
    private Boolean isPresent;
}
