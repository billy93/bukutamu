/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;

public class FinanceAccountingManagerApproveForm {
    private String refundId;
    private BigDecimal refundAmount;
    private String noteFinance;

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getNoteFinance() {
        return noteFinance;
    }

    public void setNoteFinance(String noteFinance) {
        this.noteFinance = noteFinance;
    }
}
