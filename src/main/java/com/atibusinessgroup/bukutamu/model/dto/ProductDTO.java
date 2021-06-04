package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductDTO  implements Serializable {

    private String id;
    private String productName;
    private String value;
    private String productDescription;
    private String planTypeNum;
    private ProductTypeDTO productType;
    private Set<AreaGroupDTO> areaGroups = new HashSet<>();
    private TravelDurationDTO travelDuration;
    private Set<AddonDTO> addons = new HashSet<>();
    private String productWording;
    private String productBrochure;
    private String productId;
    private Set<TravelAgentProductDTO> travelAgentProducts = new HashSet<>();
    private String productPersonalAccidentCover;
    private String productMedicalCover;
    private String productTravelCover;
    private ProductDTO productAdditionalWeek;
    private TravelAgentProductDTO travelAgentProductAdditionalWeek;
    private BigDecimal finalPrice;
    private BigDecimal finalAjiPrice;
    private BigDecimal finalAfterCommisionPrice;

    public ProductDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Set<TravelAgentProductDTO> getTravelAgentProducts() {
        return travelAgentProducts;
    }

    public void setTravelAgentProducts(Set<TravelAgentProductDTO> travelAgentProducts) {
        this.travelAgentProducts = travelAgentProducts;
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

    public ProductDTO getProductAdditionalWeek() {
        return productAdditionalWeek;
    }

    public void setProductAdditionalWeek(ProductDTO productAdditionalWeek) {
        this.productAdditionalWeek = productAdditionalWeek;
    }

    public TravelAgentProductDTO getTravelAgentProductAdditionalWeek() {
        return travelAgentProductAdditionalWeek;
    }

    public void setTravelAgentProductAdditionalWeek(TravelAgentProductDTO travelAgentProductAdditionalWeek) {
        this.travelAgentProductAdditionalWeek = travelAgentProductAdditionalWeek;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getFinalAjiPrice() {
        return finalAjiPrice;
    }

    public void setFinalAjiPrice(BigDecimal finalAjiPrice) {
        this.finalAjiPrice = finalAjiPrice;
    }

    public BigDecimal getFinalAfterCommisionPrice() {
        return finalAfterCommisionPrice;
    }

    public void setFinalAfterCommisionPrice(BigDecimal finalAfterCommisionPrice) {
        this.finalAfterCommisionPrice = finalAfterCommisionPrice;
    }

    public String getPlanTypeNum() {
        return planTypeNum;
    }

    public void setPlanTypeNum(String planTypeNum) {
        this.planTypeNum = planTypeNum;
    }
}
