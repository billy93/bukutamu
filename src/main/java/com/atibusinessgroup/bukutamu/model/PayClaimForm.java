/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class PayClaimForm {
    private String claimId;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date lodReceivedDate;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date paymentDate;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date paymentProcessingDate;
    private String proofOfPayment;
    private BigDecimal claimAmount;

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public Date getLodReceivedDate() {
        return lodReceivedDate;
    }

    public void setLodReceivedDate(Date lodReceivedDate) {
        this.lodReceivedDate = lodReceivedDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentProcessingDate() {
        return paymentProcessingDate;
    }

    public void setPaymentProcessingDate(Date paymentProcessingDate) {
        this.paymentProcessingDate = paymentProcessingDate;
    }

    public String getProofOfPayment() {
        return proofOfPayment;
    }

    public void setProofOfPayment(String proofOfPayment) {
        this.proofOfPayment = proofOfPayment;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }
}
