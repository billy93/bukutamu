package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class AddonDTO implements Serializable {
    private Long id;
    private String addonName;
    private String addonType;
    private String addonDescription;
    private String value;
    private int size;

    public AddonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddonName() {
        return addonName;
    }

    public void setAddonName(String addonName) {
        this.addonName = addonName;
    }

    public String getAddonType() {
        return addonType;
    }

    public void setAddonType(String addonType) {
        this.addonType = addonType;
    }

    public String getAddonDescription() {
        return addonDescription;
    }

    public void setAddonDescription(String addonDescription) {
        this.addonDescription = addonDescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
