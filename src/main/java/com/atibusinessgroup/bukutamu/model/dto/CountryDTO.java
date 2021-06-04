package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class CountryDTO implements Serializable {
    private Long id;
    private String countryName;
    private String countryCode;
    private Integer countryIataCode;
    private Integer postCode;
    private String associatedAirport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getCountryIataCode() {
        return countryIataCode;
    }

    public void setCountryIataCode(Integer countryIataCode) {
        this.countryIataCode = countryIataCode;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getAssociatedAirport() {
        return associatedAirport;
    }

    public void setAssociatedAirport(String associatedAirport) {
        this.associatedAirport = associatedAirport;
    }
}
