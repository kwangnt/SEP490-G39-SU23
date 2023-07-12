package com.teachsync.dtos.wallet;

import com.teachsync.dtos.BaseReadDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.teachsync.entities.Wallet}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletReadDTO extends BaseReadDTO {
    private Long userId;
    private Long paymentId;
    private Double currentBalance;
    private String note;
    private Double amountChange;
    private LocalDateTime changeAt;
}