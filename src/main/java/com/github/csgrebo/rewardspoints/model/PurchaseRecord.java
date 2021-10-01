package com.github.csgrebo.rewardspoints.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "PURCHASE")
public class PurchaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ID")
    private Long purchaseId;

    @Column(name = "PURCHASE_AMOUNT", precision = 12, scale = 2, nullable = false)
    @NotNull
    private BigDecimal purchaseAmount;

    @Column(name = "PURCHASE_DATE", nullable = false)
    @NotNull
    private LocalDateTime purchaseDate;

    @ManyToOne(targetEntity = CustomerRecord.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    @NotNull
    private CustomerRecord customer;

    public PurchaseRecord() {

    }

    public PurchaseRecord(BigDecimal purchaseAmount, LocalDateTime purchaseDate, CustomerRecord customer) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseDate = purchaseDate;
        this.customer = customer;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public CustomerRecord getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRecord customer) {
        this.customer = customer;
    }
}
