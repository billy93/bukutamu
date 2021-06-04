/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

public class CallCenterNotifyLODSubmitterForm {
    private String claimId;
    private String notificationType;
    private String description;

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
