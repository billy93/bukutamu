package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class AreaGroupDTO implements Serializable {
    private Long id;
    private String areaGroupName;
    private String areaGroupDescription;

    public AreaGroupDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaGroupName() {
        return areaGroupName;
    }

    public void setAreaGroupName(String areaGroupName) {
        this.areaGroupName = areaGroupName;
    }

    public String getAreaGroupDescription() {
        return areaGroupDescription;
    }

    public void setAreaGroupDescription(String areaGroupDescription) {
        this.areaGroupDescription = areaGroupDescription;
    }
}
