package com.teachsync.entities;

import com.teachsync.utils.enums.RequestType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "request")
public class Request extends BaseEntity {
    @Column(name = "requesterId", nullable = false)
    private Long requesterId;

    @Column(name = "requestName", nullable = false, length = 45)
    private String requestName;

    @Lob
    @Column(name = "requestDesc", nullable = false, length = -1)
    private String requestDesc;

    @Column(name = "requestType", nullable = false, length = 45)
    private RequestType requestType;

    @Column(name = "clazzId", nullable = true)
    private Long clazzId;

    @Column(name = "requestContent", nullable = true)
    private byte[] requestContent;

    @Lob
    @Column(name = "contentLink", nullable = true, length = -1)
    private String contentLink;

    @Column(name = "resolverId", nullable = true)
    private Long resolverId;
}