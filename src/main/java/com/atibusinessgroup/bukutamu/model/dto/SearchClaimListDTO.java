package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchClaimListDTO  implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> claimNumber =  Optional.of("");
    private Optional<String> policyNumber =  Optional.of("");
    private Optional<String> travelAgent =  Optional.of("");
    private Optional<String> travellerName =  Optional.of("");
    private Optional<String> claimType =  Optional.of("");
    private Optional<String> claimStatus =  Optional.of("");

    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date submittedDate = null;

    
    public Optional<String> getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(Optional<String> claimNumber) {
		this.claimNumber = claimNumber;
	}

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

    public Optional<String> getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(Optional<String> travelAgent) {
        this.travelAgent = travelAgent;
    }

    public Optional<String> getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(Optional<String> travellerName) {
        this.travellerName = travellerName;
    }

    public Optional<String> getClaimType() {
        return claimType;
    }

    public void setClaimType(Optional<String> claimType) {
        this.claimType = claimType;
    }

    public Optional<String> getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(Optional<String> claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }


    @Override
    public String toString() {
        return "SearchClaimListDTO{" +
            "page=" + page +
            ", size=" + size +
            ", policyNumber=" + policyNumber +
            ", travelAgent=" + travelAgent +
            ", travellerName=" + travellerName +
            ", claimType=" + claimType +
            ", claimStatus=" + claimStatus +
            ", submittedDate=" + submittedDate +
            '}';
    }
}
