/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;

public class RequestOperationManagerApprovalForm {
    private String refundId;
    private BigDecimal refundAmount;
    private String noteCallCenter;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getNoteCallCenter() {
        return noteCallCenter;
    }

    public void setNoteCallCenter(String noteCallCenter) {
        this.noteCallCenter = noteCallCenter;
    }

    @Override
    public String toString() {
        return "RequestOperationManagerApprovalForm{" +
            "refundId='" + refundId + '\'' +
            ", refundAmount=" + refundAmount +
            ", noteCallCenter='" + noteCallCenter + '\'' +
            '}';
    }
}
