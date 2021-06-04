package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class TravelDurationDTO  implements Serializable {
    private Long id;
    private String travelDurationName;
    private String travelDurationDescription;

    public TravelDurationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTravelDurationName() {
        return travelDurationName;
    }

    public void setTravelDurationName(String travelDurationName) {
        this.travelDurationName = travelDurationName;
    }

    public String getTravelDurationDescription() {
        return travelDurationDescription;
    }

    public void setTravelDurationDescription(String travelDurationDescription) {
        this.travelDurationDescription = travelDurationDescription;
    }
}
