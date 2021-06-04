/*
 * Copyright (c) 2020. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.util.List;

public class ResendPolicyEmailForm {
    private String salesTravelInsuranceId;
    private String travellerId;
    private String to;

    public String getSalesTravelInsuranceId() {
        return salesTravelInsuranceId;
    }

    public void setSalesTravelInsuranceId(String salesTravelInsuranceId) {
        this.salesTravelInsuranceId = salesTravelInsuranceId;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "ResendPolicyEmailForm{" +
                "salesTravelInsuranceId='" + salesTravelInsuranceId + '\'' +
                ", travellerId='" + travellerId + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
