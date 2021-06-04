/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.util.List;

public class NotifyEtiqaMultipleForm {
    private List<String> refundId;

    public List<String> getRefundId() {
        return refundId;
    }

    public void setRefundId(List<String> refundId) {
        this.refundId = refundId;
    }

    @Override
    public String toString() {
        return "NotifyEtiqaMultipleForm{" +
            "refundId=" + refundId +
            '}';
    }
}
