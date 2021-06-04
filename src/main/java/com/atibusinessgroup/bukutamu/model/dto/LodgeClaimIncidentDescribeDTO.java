package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;

public class LodgeClaimIncidentDescribeDTO {
    private String id;
    private String description;
    private Instant timestamp;
    private Instant lastUpdated;

    public LodgeClaimIncidentDescribeDTO() {
    }

    public LodgeClaimIncidentDescribeDTO(String id, String description, Instant timestamp) {
        this.id = id;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
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
