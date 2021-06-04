/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SubmitLODForm {
    private String claimId;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date sentDate;
    private String sentBy;
    @DateTimeFormat(pattern = "dd MMM yyyy")
    private Date arrivalEstimationDate;
    private String resiNumber;
    private String attachment;
    
    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }

    public Date getArrivalEstimationDate() {
        return arrivalEstimationDate;
    }

    public void setArrivalEstimationDate(Date arrivalEstimationDate) {
        this.arrivalEstimationDate = arrivalEstimationDate;
    }

	public String getResiNumber() {
		return resiNumber;
	}

	public void setResiNumber(String resiNumber) {
		this.resiNumber = resiNumber;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
    
    
}
