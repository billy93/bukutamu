package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TravelAgentProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Boolean npwp;
    private BigDecimal premiumPrice;
    private BigDecimal commisionLv1;
    private BigDecimal commisionLv2;
    private BigDecimal commisionLv3;
    private BigDecimal totalCommision;
    private BigDecimal afterCommisionPrice;
    private BigDecimal ppn;
    private BigDecimal pph23;
    private BigDecimal ppnValue;
    private BigDecimal pph23Value;
    private BigDecimal ajiPrice;

    private ProductMasterDTO product;
    private TravelAgentDTO travelAgent;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getNpwp() {
        return npwp;
    }

    public void setNpwp(Boolean npwp) {
        this.npwp = npwp;
    }

    public BigDecimal getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(BigDecimal premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    public BigDecimal getCommisionLv1() {
        return commisionLv1;
    }

    public void setCommisionLv1(BigDecimal commisionLv1) {
        this.commisionLv1 = commisionLv1;
    }

    public BigDecimal getCommisionLv2() {
        return commisionLv2;
    }

    public void setCommisionLv2(BigDecimal commisionLv2) {
        this.commisionLv2 = commisionLv2;
    }

    public BigDecimal getCommisionLv3() {
        return commisionLv3;
    }

    public void setCommisionLv3(BigDecimal commisionLv3) {
        this.commisionLv3 = commisionLv3;
    }

    public BigDecimal getTotalCommision() {
        return totalCommision;
    }

    public void setTotalCommision(BigDecimal totalCommision) {
        this.totalCommision = totalCommision;
    }

    public BigDecimal getAfterCommisionPrice() {
        return afterCommisionPrice;
    }

    public void setAfterCommisionPrice(BigDecimal afterCommisionPrice) {
        this.afterCommisionPrice = afterCommisionPrice;
    }

    public BigDecimal getPpn() {
        return ppn;
    }

    public void setPpn(BigDecimal ppn) {
        this.ppn = ppn;
    }

    public BigDecimal getPph23() {
        return pph23;
    }

    public void setPph23(BigDecimal pph23) {
        this.pph23 = pph23;
    }

    public BigDecimal getPpnValue() {
        return ppnValue;
    }

    public void setPpnValue(BigDecimal ppnValue) {
        this.ppnValue = ppnValue;
    }

    public BigDecimal getPph23Value() {
        return pph23Value;
    }

    public void setPph23Value(BigDecimal pph23Value) {
        this.pph23Value = pph23Value;
    }

    public BigDecimal getAjiPrice() {
        return ajiPrice;
    }

    public void setAjiPrice(BigDecimal ajiPrice) {
        this.ajiPrice = ajiPrice;
    }

    public ProductMasterDTO getProduct() {
        return product;
    }

    public void setProduct(ProductMasterDTO product) {
        this.product = product;
    }

    public TravelAgentDTO getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(TravelAgentDTO travelAgent) {
        this.travelAgent = travelAgent;
    }
}
