/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

public class ApproveAppealForm {
    private String claimId;
    private String proposedAdjustment;
    private String letterOfDischargeDraft;
    
    private String description;
    
    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

	public String getProposedAdjustment() {
		return proposedAdjustment;
	}

	public void setProposedAdjustment(String proposedAdjustment) {
		this.proposedAdjustment = proposedAdjustment;
	}

	public String getLetterOfDischargeDraft() {
		return letterOfDischargeDraft;
	}

	public void setLetterOfDischargeDraft(String letterOfDischargeDraft) {
		this.letterOfDischargeDraft = letterOfDischargeDraft;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
    
    
}
