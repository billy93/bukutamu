/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchSystemParameterMasterDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> productName = Optional.ofNullable("");
    private Optional<String> productId =  Optional.ofNullable("");
    private Optional<String> productType =  Optional.ofNullable("");
    private Optional<String> productCode = Optional.ofNullable("");
    private Optional<String> productDtlCode = Optional.ofNullable("");
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

    public Optional<String> getProductName() {
        return productName;
    }

    public void setProductName(Optional<String> productName) {
        this.productName = productName;
    }

    public Optional<String> getProductType() {
        return productType;
    }

    public void setProductType(Optional<String> productType) {
        this.productType = productType;
    }

    public Optional<String> getProductCode() {
        return productCode;
    }

    public void setProductCode(Optional<String> productCode) {
        this.productCode = productCode;
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

    public Optional<String> getProductDtlCode() {
        return productDtlCode;
    }

    public void setProductDtlCode(Optional<String> productDtlCode) {
        this.productDtlCode = productDtlCode;
    }

    //    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private Optional<Date> receivedDateFrom = Optional.ofNullable(null);
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private Optional<Date> receivedDateTo = Optional.ofNullable(null);
//
//    private String name;
//    private String policyNumber;
//    private String transactionId;
//    private String productId;
//    private int page;
//    private int size;

}
