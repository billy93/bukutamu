/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinanceAccountingManagerRejectMultipleForm {
    private List<FinanceAccountingManagerRejectForm> financeAccountingManagerRejectFormList = new ArrayList<>();

    public List<FinanceAccountingManagerRejectForm> getFinanceAccountingManagerRejectFormList() {
        return financeAccountingManagerRejectFormList;
    }

    public void setFinanceAccountingManagerRejectFormList(List<FinanceAccountingManagerRejectForm> financeAccountingManagerRejectFormList) {
        this.financeAccountingManagerRejectFormList = financeAccountingManagerRejectFormList;
    }
}
