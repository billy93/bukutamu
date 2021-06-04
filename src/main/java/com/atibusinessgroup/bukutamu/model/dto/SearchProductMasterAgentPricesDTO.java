/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Optional;

public class SearchProductMasterAgentPricesDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> travelAgentName = Optional.ofNullable("");
    private Optional<String> planType =  Optional.ofNullable("");
    private Optional<String> tripType =  Optional.ofNullable("");
    private Optional<String> travellerType = Optional.ofNullable("");

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

    public Optional<String> getTravelAgentName() {
        return travelAgentName;
    }

    public void setTravelAgentName(Optional<String> travelAgentName) {
        this.travelAgentName = travelAgentName;
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
}
