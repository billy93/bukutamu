/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

public class TravelAgentProductDataDTO {
    private Long id;
    private String productName;
    private String productCode;
    private String productDtlCode;
    private String currId;
    private String premiumPrice;
    private String productDescription;
    private String productPersonalAccidentCover;
    private String productMedicalCover;
    private String productTravelCover;
    private String productWording;
    private String productBrochure;
    private String travelDuration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDtlCode() {
        return productDtlCode;
    }

    public void setProductDtlCode(String productDtlCode) {
        this.productDtlCode = productDtlCode;
    }

    public String getCurrId() {
        return currId;
    }

    public void setCurrId(String currId) {
        this.currId = currId;
    }

    public String getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(String premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPersonalAccidentCover() {
        return productPersonalAccidentCover;
    }

    public void setProductPersonalAccidentCover(String productPersonalAccidentCover) {
        this.productPersonalAccidentCover = productPersonalAccidentCover;
    }

    public String getProductMedicalCover() {
        return productMedicalCover;
    }

    public void setProductMedicalCover(String productMedicalCover) {
        this.productMedicalCover = productMedicalCover;
    }

    public String getProductTravelCover() {
        return productTravelCover;
    }

    public void setProductTravelCover(String productTravelCover) {
        this.productTravelCover = productTravelCover;
    }

    public String getProductWording() {
        return productWording;
    }

    public void setProductWording(String productWording) {
        this.productWording = productWording;
    }

    public String getProductBrochure() {
        return productBrochure;
    }

    public void setProductBrochure(String productBrochure) {
        this.productBrochure = productBrochure;
    }

    public String getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(String travelDuration) {
        this.travelDuration = travelDuration;
    }
}
