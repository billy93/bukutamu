/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SearchCriteriaTravellerForm {
    private String fullname;

    @JsonFormat(pattern = "dd MMMM yyyy")
    private Date dateOfBirth;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "SearchCriteriaTravellerForm{" +
            "fullname='" + fullname + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            '}';
    }
}
