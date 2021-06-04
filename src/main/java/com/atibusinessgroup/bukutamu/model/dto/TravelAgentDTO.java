/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

public class TravelAgentDTO {
    private Long id;
    private String travelAgentName;
    private String travelAgentPhone;
    private String travelAgentEmail;
    private String travelAgentAddress;
    private String commission;
    private String paymentType;
    private boolean allowCreditPayment;
    private String custcode;
    private String custid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTravelAgentName() {
        return travelAgentName;
    }

    public void setTravelAgentName(String travelAgentName) {
        this.travelAgentName = travelAgentName;
    }

    public String getTravelAgentPhone() {
        return travelAgentPhone;
    }

    public void setTravelAgentPhone(String travelAgentPhone) {
        this.travelAgentPhone = travelAgentPhone;
    }

    public String getTravelAgentEmail() {
        return travelAgentEmail;
    }

    public void setTravelAgentEmail(String travelAgentEmail) {
        this.travelAgentEmail = travelAgentEmail;
    }

    public String getTravelAgentAddress() {
        return travelAgentAddress;
    }

    public void setTravelAgentAddress(String travelAgentAddress) {
        this.travelAgentAddress = travelAgentAddress;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isAllowCreditPayment() {
        return allowCreditPayment;
    }

    public void setAllowCreditPayment(boolean allowCreditPayment) {
        this.allowCreditPayment = allowCreditPayment;
    }

    public String getCustcode() {
        return custcode;
    }

    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }
}
