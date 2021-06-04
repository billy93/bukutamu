/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductFormDTO {

    private Long id;
    private String productName;
    private String productCode;
    private String productDtlCode;
    private String currId;
    private String value;
    private String productDescription;
    private String productPersonalAccidentCover;
    private String productMedicalCover;
    private String productTravelCover;
    private String productWording;
    private String productBrochure;
    private String productTypeId;
    private String productAdditionalWeekId;
    private Set<String> areaGroupsId = new HashSet<>();
    private String travelDurationId;
    private Set<String> addonsId = new HashSet<>();
    private Set<String> travelAgentProductsId = new HashSet<>();

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductAdditionalWeekId() {
        return productAdditionalWeekId;
    }

    public void setProductAdditionalWeekId(String productAdditionalWeekId) {
        this.productAdditionalWeekId = productAdditionalWeekId;
    }

    public Set<String> getAreaGroupsId() {
        return areaGroupsId;
    }

    public void setAreaGroupsId(Set<String> areaGroupsId) {
        this.areaGroupsId = areaGroupsId;
    }

    public String getTravelDurationId() {
        return travelDurationId;
    }

    public void setTravelDurationId(String travelDurationId) {
        this.travelDurationId = travelDurationId;
    }

    public Set<String> getAddonsId() {
        return addonsId;
    }

    public void setAddonsId(Set<String> addonsId) {
        this.addonsId = addonsId;
    }

    public Set<String> getTravelAgentProductsId() {
        return travelAgentProductsId;
    }

    public void setTravelAgentProductsId(Set<String> travelAgentProductsId) {
        this.travelAgentProductsId = travelAgentProductsId;
    }

    @Override
    public String toString() {
        return "ProductFormDTO{" +
            "id=" + id +
            ", productName='" + productName + '\'' +
            ", productCode='" + productCode + '\'' +
            ", productDtlCode='" + productDtlCode + '\'' +
            ", currId='" + currId + '\'' +
            ", value='" + value + '\'' +
            ", productDescription='" + productDescription + '\'' +
            ", productPersonalAccidentCover='" + productPersonalAccidentCover + '\'' +
            ", productMedicalCover='" + productMedicalCover + '\'' +
            ", productTravelCover='" + productTravelCover + '\'' +
            ", productWording='" + productWording + '\'' +
            ", productBrochure='" + productBrochure + '\'' +
            ", productTypeId='" + productTypeId + '\'' +
            ", productAdditionalWeekId='" + productAdditionalWeekId + '\'' +
            ", areaGroupsId=" + areaGroupsId +
            ", travelDurationId='" + travelDurationId + '\'' +
            ", addonsId=" + addonsId +
            ", travelAgentProductsId=" + travelAgentProductsId +
            '}';
    }
}
