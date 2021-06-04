/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;

public class OperationManagerRejectForm {
    private String refundId;
    private BigDecimal refundAmount;
    private String noteRejectedOm;

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

    public String getNoteRejectedOm() {
        return noteRejectedOm;
    }

    public void setNoteRejectedOm(String noteRejectedOm) {
        this.noteRejectedOm = noteRejectedOm;
    }

    @Override
    public String toString() {
        return "OperationManagerRejectForm{" +
            "refundId='" + refundId + '\'' +
            ", refundAmount=" + refundAmount +
            ", noteRejectedOm='" + noteRejectedOm + '\'' +
            '}';
    }
}
