package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;

public class LodgeClaimFinancialDetailDTO {

    private String id;
    private BankDTO bank;
    private String bankAccountHolderName;
    private String accountNumber;
    private Instant timestamp;
    private Instant lastUpdated;

    public LodgeClaimFinancialDetailDTO() {
    }

    public LodgeClaimFinancialDetailDTO(String id, BankDTO bank, String bankAccountHolderName, String accountNumber, Instant timestamp) {
        this.id = id;
        this.bank = bank;
        this.bankAccountHolderName = bankAccountHolderName;
        this.accountNumber = accountNumber;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
