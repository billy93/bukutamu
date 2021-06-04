/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SaveCriteriaTravellerForm {
    private String id;
    private String travelInsuranceId;
    private String updateTravellerId;

    public String getTravelInsuranceId() {
        return travelInsuranceId;
    }

    public void setTravelInsuranceId(String travelInsuranceId) {
        this.travelInsuranceId = travelInsuranceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateTravellerId() {
        return updateTravellerId;
    }

    public void setUpdateTravellerId(String updateTravellerId) {
        this.updateTravellerId = updateTravellerId;
    }
}
