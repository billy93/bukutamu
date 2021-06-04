package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class AuthorityDTO implements Serializable {
    private String name;

    
    public AuthorityDTO() {
		super();
	}

	public AuthorityDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
