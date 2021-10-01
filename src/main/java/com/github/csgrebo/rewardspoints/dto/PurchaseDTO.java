package com.github.csgrebo.rewardspoints.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseDTO {

    private LocalDateTime purchaseDate;
    private BigDecimal purchaseAmount;
    private Long purchaseId;

    public PurchaseDTO(LocalDateTime purchaseDate, BigDecimal purchaseAmount, Long purchaseId) {
        this.purchaseDate = purchaseDate;
        this.purchaseAmount = purchaseAmount;
        this.purchaseId = purchaseId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
}
