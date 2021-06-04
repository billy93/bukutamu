/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class SearchProductMasterNonOptionalDTO implements Serializable {

    private Integer page = 0;
    private Integer size = 10;

    private String travelAgentName = "";
    private String tripType = "";
    private String planType = "";
    private String travellerType = "";
    private String productDtlCode = "";

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getTravelAgentName() {
        return travelAgentName;
    }

    public void setTravelAgentName(String travelAgentName) {
        this.travelAgentName = travelAgentName;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
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

    public String getProductDtlCode() {
        return productDtlCode;
    }

    public void setProductDtlCode(String productDtlCode) {
        this.productDtlCode = productDtlCode;
    }
}
