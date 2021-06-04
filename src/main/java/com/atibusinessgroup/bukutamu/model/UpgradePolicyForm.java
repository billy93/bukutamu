/*
 * Copyright (c) 2020. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpgradePolicyForm implements Serializable {

    private String salesTravelInsuranceId;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date from;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date to;
    private String planType;
    private String travellerType;
    private List<String> destinations;
    private String productId;
    private String travellerId;

    public String getSalesTravelInsuranceId() {
        return salesTravelInsuranceId;
    }

    public void setSalesTravelInsuranceId(String salesTravelInsuranceId) {
        this.salesTravelInsuranceId = salesTravelInsuranceId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }

    @Override
    public String toString() {
        return "UpgradePolicyForm{" +
            "salesTravelInsuranceId='" + salesTravelInsuranceId + '\'' +
            ", from=" + from +
            ", to=" + to +
            ", planType='" + planType + '\'' +
            ", travellerType='" + travellerType + '\'' +
            ", destinations='" + destinations + '\'' +
            ", productId='" + productId + '\'' +
            ", travellerId='" + travellerId + '\'' +
            '}';
    }
}
