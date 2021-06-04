package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;
import java.util.List;

public class LodgeClaimOptionDTO {
    private String id;
    private String type;
    private List<String> typeOptions;

    private Instant timestamp;
    private Instant lastUpdated;

    public LodgeClaimOptionDTO() {
    }

    public LodgeClaimOptionDTO(String id, String type, List<String> typeOptions, Instant timestamp) {
        this.id = id;
        this.type = type;
        this.typeOptions = typeOptions;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTypeOptions() {
        return typeOptions;
    }

    public void setTypeOptions(List<String> typeOptions) {
        this.typeOptions = typeOptions;
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
