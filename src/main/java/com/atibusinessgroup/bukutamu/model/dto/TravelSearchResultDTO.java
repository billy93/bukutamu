package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.List;

public class TravelSearchResultDTO implements Serializable {
    private String travelInsuranceId;
    private List<ProductDTO> products;

    public String getTravelInsuranceId() {
        return travelInsuranceId;
    }

    public void setTravelInsuranceId(String travelInsuranceId) {
        this.travelInsuranceId = travelInsuranceId;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
