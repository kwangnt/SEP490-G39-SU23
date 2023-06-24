package com.teachsync.dtos.priceLog;

import com.teachsync.utils.enums.PromotionType;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.PriceLog}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceLogReadDTO implements Serializable {
    private Long id;

    private Long courseId;

    private Double price;

    private Boolean isCurrent;

    private Boolean isPromotion;

    private PromotionType promotionType;

    private Double promotionAmount;

    private String promotionDesc;

    private LocalDateTime validFrom;

    private LocalDateTime validTo;

    private Status status;

    private Double finalPrice;
}
