/*
 * Copyright (c) 2020. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class HistoryDTO  implements Serializable {
    private String id;
    private String message;
    private String travellerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String travellerId) {
        this.travellerId = travellerId;
    }
}
