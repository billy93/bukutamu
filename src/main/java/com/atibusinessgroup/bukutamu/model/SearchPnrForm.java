package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SearchPnrForm {
    private String id;
    private String pnr;

    private String planType;
    private String travellerType;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getTravellerType() {
		return travellerType;
	}

	public void setTravellerType(String travellerType) {
		this.travellerType = travellerType;
	}
    
    
}

