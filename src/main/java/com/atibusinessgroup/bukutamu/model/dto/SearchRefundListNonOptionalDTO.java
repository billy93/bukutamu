package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchRefundListNonOptionalDTO implements Serializable {

    private Integer page = 0;
    private Integer size = 10;

    private String policyNumber = "";
    private String travellerName = "";
    private String bookingId = "";
    private String productName = "";
    private String refundStatus = "";
    private String issuedBy = "";

    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date refundDate;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    @Override
    public String toString() {
        return "SearchRefundListNonOptionalDTO{" +
            "page=" + page +
            ", size=" + size +
            ", policyNumber='" + policyNumber + '\'' +
            ", travellerName='" + travellerName + '\'' +
            ", bookingId='" + bookingId + '\'' +
            ", productName='" + productName + '\'' +
            ", refundStatus='" + refundStatus + '\'' +
            ", issuedBy='" + issuedBy + '\'' +
            ", refundDate=" + refundDate +
            '}';
    }
}
