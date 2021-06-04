/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class ProductMasterDTO {

    private static final long serialVersionUID = 1L;

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
    private ProductTypeDTO productType;
    private ProductMasterDTO productAdditionalWeek;
    private Set<AreaGroupDTO> areaGroups = new HashSet<>();
    private TravelDurationDTO travelDuration;
    private Set<AddonDTO> addons = new HashSet<>();
    private Set<TravelAgentProductDTO> travelAgentProducts = new HashSet<>();
    private Instant updatedDate = Instant.now();
    private String planTypeNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public ProductMasterDTO getProductAdditionalWeek() {
        return productAdditionalWeek;
    }

    public void setProductAdditionalWeek(ProductMasterDTO productAdditionalWeek) {
        this.productAdditionalWeek = productAdditionalWeek;
    }

    public Set<AreaGroupDTO> getAreaGroups() {
        return areaGroups;
    }

    public void setAreaGroups(Set<AreaGroupDTO> areaGroups) {
        this.areaGroups = areaGroups;
    }

    public TravelDurationDTO getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(TravelDurationDTO travelDuration) {
        this.travelDuration = travelDuration;
    }

    public Set<AddonDTO> getAddons() {
        return addons;
    }

    public void setAddons(Set<AddonDTO> addons) {
        this.addons = addons;
    }

    public Set<TravelAgentProductDTO> getTravelAgentProducts() {
        return travelAgentProducts;
    }

    public void setTravelAgentProducts(Set<TravelAgentProductDTO> travelAgentProducts) {
        this.travelAgentProducts = travelAgentProducts;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getPlanTypeNum() {
        return planTypeNum;
    }

    public void setPlanTypeNum(String planTypeNum) {
        this.planTypeNum = planTypeNum;
    }

    @Override
    public String toString() {
        return "ProductMasterDTO{" +
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
            ", productType=" + productType +
            ", productAdditionalWeek=" + productAdditionalWeek +
            ", areaGroups=" + areaGroups +
            ", travelDuration=" + travelDuration +
            ", addons=" + addons +
            ", travelAgentProducts=" + travelAgentProducts +
            ", updatedDate=" + updatedDate +
            ", planTypeNum='" + planTypeNum + '\'' +
            '}';
    }
}
