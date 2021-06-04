/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

public class UpdateNikForm {
    private String travelInsuranceId;
    private String nik;
    private String fullname;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTravelInsuranceId() {
        return travelInsuranceId;
    }

    public void setTravelInsuranceId(String travelInsuranceId) {
        this.travelInsuranceId = travelInsuranceId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "UpdateNikForm{" +
            "travelInsuranceId='" + travelInsuranceId + '\'' +
            ", nik='" + nik + '\'' +
            ", fullname='" + fullname + '\'' +
            '}';
    }
}
