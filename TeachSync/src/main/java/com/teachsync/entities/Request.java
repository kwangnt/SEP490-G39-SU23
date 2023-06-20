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
public class Request extends BaseEntity {
    @Column(name = "requesterId", nullable = false)
    private Long requesterId;
    
    @Column(name = "requestName", nullable = false, length = 45)
    private String requestName;

    @Lob
    @Column(name = "requestDesc", nullable = false, length = -1)
    private String requestDesc;
    
    @Column(name = "requestType", nullable = false, length = 45)
    private String requestType;
    
    @Column(name = "clazzId", nullable = true)
    private Long clazzId;
    
    @Column(name = "contentLink", nullable = true)
    private byte[] contentLink;

    @Lob
    @Column(name = "requestContent", nullable = true, length = -1)
    private String requestContent;
    
    @Column(name = "resolverId", nullable = true)
    private Long resolverId;
}