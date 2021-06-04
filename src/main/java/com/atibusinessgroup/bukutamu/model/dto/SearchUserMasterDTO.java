/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Optional;

public class SearchUserMasterDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> fullname = Optional.ofNullable("");
    private Optional<String> email =  Optional.ofNullable("");
    private Optional<String> role =  Optional.ofNullable("");

    public Optional<Integer> getPage() {
        return page;
    }

    public void setPage(Optional<Integer> page) {
        this.page = page;
    }

    public Optional<Integer> getSize() {
        return size;
    }

    public void setSize(Optional<Integer> size) {
        this.size = size;
    }

    public Optional<String> getFullname() {
        return fullname;
    }

    public void setFullname(Optional<String> fullname) {
        this.fullname = fullname;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public Optional<String> getRole() {
        return role;
    }

    public void setRole(Optional<String> role) {
        this.role = role;
    }
}
