package com.atibusinessgroup.bukutamu.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IncidentLocationLodgeClaimForm {
	private String claimId;
	@DateTimeFormat(pattern = "dd MMM yyyy")
	private Date dateTimeOfIncident;
	private String country;
	private String address;

	private String hour;
    private String minute;
    private String format;

    public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public Date getDateTimeOfIncident() {
		return dateTimeOfIncident;
	}

	public void setDateTimeOfIncident(Date dateTimeOfIncident) {
		this.dateTimeOfIncident = dateTimeOfIncident;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
