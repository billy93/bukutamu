/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;

public class RequestFinanceAccountingManagerApprovalForm {
    private String refundId;
    private String noteOm;
    private BigDecimal refundAmount;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getNoteOm() {
        return noteOm;
    }

    public void setNoteOm(String noteOm) {
        this.noteOm = noteOm;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
}
