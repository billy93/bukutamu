package com.atibusinessgroup.bukutamu.model;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
    private int travelAgentId = -1;
    private String idToken;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String policyNumber;
    private String travelAgentName;
    private List<String> role;

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public int getTravelAgentId() {
        return travelAgentId;
    }

    public void setTravelAgentId(int travelAgentId) {
        this.travelAgentId = travelAgentId;
    }

    public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

    public String getTravelAgentName() {
        return travelAgentName;
    }

    public void setTravelAgentName(String travelAgentName) {
        this.travelAgentName = travelAgentName;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}
