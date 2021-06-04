package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class SelectAddonDTO  implements Serializable {
    private String id;
    private List<AddonDTO> addons = new ArrayList<>();
    private BigDecimal totalPrice;
    private Instant timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AddonDTO> getAddons() {
        return addons;
    }

    public void setAddons(List<AddonDTO> addons) {
        this.addons = addons;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
