package com.atibusinessgroup.bukutamu.model;

public class CreateLodgeClaimForm {
	private String claimId;
	private String claimType;
	private String type;
	private String policyNumber;


	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

    @Override
    public String toString() {
        return "CreateLodgeClaimForm{" +
            "claimId='" + claimId + '\'' +
            ", claimType='" + claimType + '\'' +
            ", type='" + type + '\'' +
            ", policyNumber='" + policyNumber + '\'' +
            '}';
    }
}
