package com.teachsync.dtos.priceLog;

import com.teachsync.dtos.BaseReadDTO;
import com.teachsync.utils.enums.PromotionType;
import com.teachsync.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.PriceLog}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceLogReadDTO extends BaseReadDTO {
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
