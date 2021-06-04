package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SubmitClaimForm {
	private String claimId;
	private boolean selfClaim;
    @DateTimeFormat(pattern = "dd MMM yyyy")
	private Date reportDate;
    private String yourName;

	public String getClaimId() {
		return claimId;
	}
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	public boolean isSelfClaim() {
		return selfClaim;
	}
	public void setSelfClaim(boolean selfClaim) {
		this.selfClaim = selfClaim;
	}

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getYourName() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }
}
