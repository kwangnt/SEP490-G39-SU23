package com.teachsync.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet extends BaseEntity {
    @Column(name = "userId", nullable = false)
    private Long userId;
    
    @Column(name = "paymentId", nullable = true)
    private Long paymentId;
    
    @Column(name = "currentBalance", nullable = false, precision = 0)
    private Double currentBalance;
    
    @Column(name = "note", nullable = true, length = 255)
    private String note;
    
    @Column(name = "amountChange", nullable = false, precision = 0)
    private Double amountChange;
    
    @Column(name = "changeAt", nullable = false)
    private LocalDateTime changeAt;
}