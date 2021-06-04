package com.atibusinessgroup.bukutamu.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CheckCreditLimit {
    @NotNull
    @NotEmpty
    private String travelInsuranceId;
    private BigDecimal amount;

    public String getTravelInsuranceId() {
        return travelInsuranceId;
    }

    public void setTravelInsuranceId(String travelInsuranceId) {
        this.travelInsuranceId = travelInsuranceId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CheckCreditLimit{" +
                "travelInsuranceId='" + travelInsuranceId + '\'' +
                ", amount=" + amount +
                '}';
    }
}

