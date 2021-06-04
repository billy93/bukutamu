package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchPolicyListDTO  implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> name = Optional.ofNullable("");
    private Optional<String> policyNumber =  Optional.ofNullable("");
    private Optional<String> transactionId =  Optional.ofNullable("");
    private Optional<String> productId = Optional.ofNullable("");
    private Optional<String> productName = Optional.ofNullable("");
    private Optional<String> statusSales = Optional.ofNullable("");
    private Optional<String> refundStatus = Optional.ofNullable("");

    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date purchaseDate = null;

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

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<String> getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Optional<String> policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Optional<String> getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Optional<String> transactionId) {
        this.transactionId = transactionId;
    }

    public Optional<String> getProductId() {
        return productId;
    }

    public void setProductId(Optional<String> productId) {
        this.productId = productId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Optional<String> getStatusSales() {
        return statusSales;
    }

    public void setStatusSales(Optional<String> statusSales) {
        this.statusSales = statusSales;
    }

    public Optional<String> getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Optional<String> refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Optional<String> getProductName() {
        return productName;
    }

    public void setProductName(Optional<String> productName) {
        this.productName = productName;
    }
}
