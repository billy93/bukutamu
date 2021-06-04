/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RequestOperationManagerApprovalMultipleForm {
    private List<RequestOperationManagerApprovalForm> requestOperationManagerApprovalForm = new ArrayList<>();

    public List<RequestOperationManagerApprovalForm> getRequestOperationManagerApprovalForm() {
        return requestOperationManagerApprovalForm;
    }

    public void setRequestOperationManagerApprovalForm(List<RequestOperationManagerApprovalForm> requestOperationManagerApprovalForm) {
        this.requestOperationManagerApprovalForm = requestOperationManagerApprovalForm;
    }
}
