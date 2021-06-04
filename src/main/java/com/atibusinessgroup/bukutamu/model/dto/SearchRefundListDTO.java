package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchRefundListDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> policyNumber =  Optional.ofNullable("");
    private Optional<String> travellerName = Optional.ofNullable("");
    private Optional<String> bookingId =  Optional.ofNullable("");
    private Optional<String> productName = Optional.ofNullable("");
    private Optional<String> refundStatus = Optional.ofNullable("");
    private Optional<String> issuedBy = Optional.ofNullable("");

    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date refundDate = null;

    public Optional<Integer> getPage() {
        return page;
    }

    public void setPage(Optional<Integer> page) {
        this.page = page;
    }

    public Optional<Integer> getSize() {
        return size;
    }

    public void setSize(Optional<Integer> size) {
        this.size = size;
    }

    public Optional<String> getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Optional<String> policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Optional<String> getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(Optional<String> travellerName) {
        this.travellerName = travellerName;
    }

    public Optional<String> getBookingId() {
        return bookingId;
    }

    public void setBookingId(Optional<String> bookingId) {
        this.bookingId = bookingId;
    }

    public Optional<String> getProductName() {
        return productName;
    }

    public void setProductName(Optional<String> productName) {
        this.productName = productName;
    }

    public Optional<String> getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Optional<String> refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public Optional<String> getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(Optional<String> issuedBy) {
        this.issuedBy = issuedBy;
    }
}
