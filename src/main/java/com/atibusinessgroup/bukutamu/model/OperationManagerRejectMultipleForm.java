/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationManagerRejectMultipleForm {
    private List<OperationManagerRejectForm> operationManagerRejectFormList = new ArrayList<>();

    public List<OperationManagerRejectForm> getOperationManagerRejectFormList() {
        return operationManagerRejectFormList;
    }

    public void setOperationManagerRejectFormList(List<OperationManagerRejectForm> operationManagerRejectFormList) {
        this.operationManagerRejectFormList = operationManagerRejectFormList;
    }
}
