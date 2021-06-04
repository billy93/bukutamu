/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;

public class CallCenterRejectForm {
    private String refundId;
    private BigDecimal refundAmount;
    private String notePendingRejectedCallCenter;

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

    public String getNotePendingRejectedCallCenter() {
        return notePendingRejectedCallCenter;
    }

    public void setNotePendingRejectedCallCenter(String notePendingRejectedCallCenter) {
        this.notePendingRejectedCallCenter = notePendingRejectedCallCenter;
    }

    @Override
    public String toString() {
        return "CallCenterRejectForm{" +
            "refundId='" + refundId + '\'' +
            ", refundAmount=" + refundAmount +
            ", notePendingRejectedCallCenter='" + notePendingRejectedCallCenter + '\'' +
            '}';
    }
}
