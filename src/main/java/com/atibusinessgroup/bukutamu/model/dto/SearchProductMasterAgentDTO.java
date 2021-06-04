/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchProductMasterAgentDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> name = Optional.ofNullable("");
    private Optional<String> planType =  Optional.ofNullable("");
    private Optional<String> tripType =  Optional.ofNullable("");
    private Optional<String> travellerType = Optional.ofNullable("");
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date purchaseDate = null;

    public Optional<Integer> getPage() {
        return page;
    }

    public void setPage(Optional<Integer> page) {
        this.page = page;
    }

    public Optional<Integer> getSize() {
        return size;
    }

    public void setSize(Optional<Integer> size) {
        this.size = size;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<String> getPlanType() {
        return planType;
    }

    public void setPlanType(Optional<String> planType) {
        this.planType = planType;
    }

    public Optional<String> getTripType() {
        return tripType;
    }

    public void setTripType(Optional<String> tripType) {
        this.tripType = tripType;
    }

    public Optional<String> getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Optional<String> travellerType) {
        this.travellerType = travellerType;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    //    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private Optional<Date> receivedDateFrom = Optional.ofNullable(null);
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private Optional<Date> receivedDateTo = Optional.ofNullable(null);
//
//    private String name;
//    private String policyNumber;
//    private String transactionId;
//    private String productId;
//    private int page;
//    private int size;

}
