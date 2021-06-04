/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppealClaimForm {
    private String claimId;
    private String description;
    private List<String> appealFile = new ArrayList<String>();

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAppealFile() {
        return appealFile;
    }

    public void setAppealFile(List<String> appealFile) {
        this.appealFile = appealFile;
    }

    @Override
    public String toString() {
        return "AppealClaimForm{" +
            "claimId='" + claimId + '\'' +
            ", description='" + description + '\'' +
            ", appealFile=" + appealFile.size() +
            '}';
    }
}
