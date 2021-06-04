/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RequestFinanceAccountingManagerApprovalMultipleForm {
    private List<RequestFinanceAccountingManagerApprovalForm> requestFinanceAccountingManagerApprovalForm = new ArrayList<>();

    public List<RequestFinanceAccountingManagerApprovalForm> getRequestFinanceAccountingManagerApprovalForm() {
        return requestFinanceAccountingManagerApprovalForm;
    }

    public void setRequestFinanceAccountingManagerApprovalForm(List<RequestFinanceAccountingManagerApprovalForm> requestFinanceAccountingManagerApprovalForm) {
        this.requestFinanceAccountingManagerApprovalForm = requestFinanceAccountingManagerApprovalForm;
    }
}
