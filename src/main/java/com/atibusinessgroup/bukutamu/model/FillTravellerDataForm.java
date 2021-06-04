package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FillTravellerDataForm {
    private String id;
    private String travelInsuranceId;

    private String travellerType;
    private String title;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern="dd MMM yyyy")
    private Date dateOfBirth;
    private String placeOfBirth;
    private String email;
    private String phone;
    private String address;
    private String passport;
    private String relationship;
    private String beneficiary;

    private String attachment;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTravelInsuranceId() {
        return travelInsuranceId;
    }

    public void setTravelInsuranceId(String travelInsuranceId) {
        this.travelInsuranceId = travelInsuranceId;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
    public String toString() {
        return "FillTravellerDataForm{" +
                "id='" + id + '\'' +
                ", travelInsuranceId='" + travelInsuranceId + '\'' +
                ", travellerType='" + travellerType + '\'' +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", passport='" + passport + '\'' +
                ", relationship='" + relationship + '\'' +
                ", beneficiary='" + beneficiary + '\'' +
                '}';
    }
}
