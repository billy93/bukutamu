package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class TOPCheckCreditLimitDTO  implements Serializable {

    private String amountRequest;
    private String amountResponse;
    private String custid;
    private String custcode;
    private String status;
    private String errorMessage;
    private boolean isLimitEnough;


    public TOPCheckCreditLimitDTO() {
    }

    public String getAmountRequest() {
        return amountRequest;
    }

    public void setAmountRequest(String amountRequest) {
        this.amountRequest = amountRequest;
    }

    public String getAmountResponse() {
        return amountResponse;
    }

    public void setAmountResponse(String amountResponse) {
        this.amountResponse = amountResponse;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustcode() {
        return custcode;
    }

    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

   
    public boolean isLimitEnough() {
		return isLimitEnough;
	}

	public void setLimitEnough(boolean isLimitEnough) {
		this.isLimitEnough = isLimitEnough;
	}

	@Override
    public String toString() {
        return "TOPCheckCreditLimitDTO{" +
                "amountRequest='" + amountRequest + '\'' +
                ", amountResponse='" + amountResponse + '\'' +
                ", custid='" + custid + '\'' +
                ", custcode='" + custcode + '\'' +
                ", status='" + status + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", isLimitEnough=" + isLimitEnough +
                '}';
    }
}
