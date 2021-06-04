/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinanceAccountingManagerApproveMultipleForm {
    private List<FinanceAccountingManagerApproveForm> financeAccountingManagerApproveFormList = new ArrayList<>();

    public List<FinanceAccountingManagerApproveForm> getFinanceAccountingManagerApproveFormList() {
        return financeAccountingManagerApproveFormList;
    }

    public void setFinanceAccountingManagerApproveFormList(List<FinanceAccountingManagerApproveForm> financeAccountingManagerApproveFormList) {
        this.financeAccountingManagerApproveFormList = financeAccountingManagerApproveFormList;
    }
}
