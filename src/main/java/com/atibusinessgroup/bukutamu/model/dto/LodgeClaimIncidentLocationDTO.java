package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;
import java.util.Date;

public class LodgeClaimIncidentLocationDTO {
    private String id;
    private Date dateTimeOfIncident;
    private CountryDTO country;
    private String address;
    private Instant timestamp;
    private Instant lastUpdated;

    public LodgeClaimIncidentLocationDTO() {
    }

    public LodgeClaimIncidentLocationDTO(String id, Date dateTimeOfIncident, CountryDTO country, String address, Instant timestamp) {
        this.id = id;
        this.dateTimeOfIncident = dateTimeOfIncident;
        this.country = country;
        this.address = address;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public Date getDateTimeOfIncident() {
        return dateTimeOfIncident;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDateTimeOfIncident(Date dateTimeOfIncident) {
        this.dateTimeOfIncident = dateTimeOfIncident;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
