/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CallCenterRejectMultipleForm {
    private List<CallCenterRejectForm> callCenterRejectFormList = new ArrayList<>();

    public List<CallCenterRejectForm> getCallCenterRejectFormList() {
        return callCenterRejectFormList;
    }

    public void setCallCenterRejectFormList(List<CallCenterRejectForm> callCenterRejectFormList) {
        this.callCenterRejectFormList = callCenterRejectFormList;
    }
}
