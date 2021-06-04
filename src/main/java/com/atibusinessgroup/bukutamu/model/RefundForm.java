/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.util.ArrayList;
import java.util.List;

public class RefundForm {

    private List<Data> data = new ArrayList<>();

    public static class Data {
        private String salesTravelInsuranceId;
        private String travellerId;

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
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data : "+data.size();
    }
}
