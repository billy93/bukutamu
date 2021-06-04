/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

public class NotifyEtiqaForm {
    private String refundId;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    @Override
    public String toString() {
        return "NotifyEtiqaForm{" +
            "refundId='" + refundId + '\'' +
            '}';
    }
}
