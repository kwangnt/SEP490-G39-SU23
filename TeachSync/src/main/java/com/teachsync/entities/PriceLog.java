package com.teachsync.entities;

import com.teachsync.utils.enums.PromotionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "price_log", schema = "teachsync")
public class PriceLog extends BaseEntity {
    @Column(name = "courseId", nullable = false)
    private Long courseId;
    
    @Column(name = "price", nullable = false, precision = 0)
    private Double price;
    
    @Column(name = "isCurrent", nullable = false)
    private Boolean isCurrent;
    
    @Column(name = "isPromotion", nullable = false)
    private Boolean isPromotion;
    
    @Column(name = "promotionAmount", nullable = true, precision = 0)
    private Double promotionAmount;
    
    @Column(name = "promotionType", nullable = true, length = 45)
    private PromotionType promotionType;

    @Lob
    @Column(name = "promotionDesc", nullable = true, length = -1)
    private String promotionDesc;
    
    @Column(name = "validFrom", nullable = false)
    private LocalDateTime validFrom;
    
    @Column(name = "validTo", nullable = true)
    private LocalDateTime validTo;
}