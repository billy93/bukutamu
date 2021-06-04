package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class LodgeClaimProvideExpenseDTO {

    private String id;
    private List<LodgeClaimProvideExpenseDTO.ProvideExpenseDTO> provideExpense;

    private Instant timestamp;
    private Instant lastUpdated;

    public LodgeClaimProvideExpenseDTO() {
    }

    public LodgeClaimProvideExpenseDTO(String id, List<LodgeClaimProvideExpenseDTO.ProvideExpenseDTO> provideExpense, Instant timestamp) {
        this.id = id;
        this.provideExpense = provideExpense;
        this.timestamp = timestamp;

        this.provideExpense.forEach(e -> {
            e.lodgeClaimProvideExpense = this;
        });
    }

    public static class ProvideExpenseDTO{
        private String id;
        private Date dateExpenseIncurred;
        private String providerName;
        private String cost;
        private CurrencyDTO currency;
        private String remarks;
        private String filename;
        private String fileurl;
        private boolean paid;

        private LodgeClaimProvideExpenseDTO lodgeClaimProvideExpense;

        public ProvideExpenseDTO() {
        }

        public ProvideExpenseDTO(String id, Date dateExpenseIncurred, String providerName, String cost, CurrencyDTO currency, String remarks, String filename, String fileurl, boolean paid) {
            this.id = id;
            this.dateExpenseIncurred = dateExpenseIncurred;
            this.providerName = providerName;
            this.cost = cost;
            this.currency = currency;
            this.remarks = remarks;
            this.filename = filename;
            this.paid = paid;
            this.fileurl = fileurl;
        }

        public String getId() {
            return id;
        }

        public Date getDateExpenseIncurred() {
            return dateExpenseIncurred;
        }

        public String getProviderName() {
            return providerName;
        }

        public String getCost() {
            return cost;
        }

        public CurrencyDTO getCurrency() {
            return currency;
        }

        public boolean isPaid() {
            return paid;
        }

        public LodgeClaimProvideExpenseDTO getLodgeClaimProvideExpense() {
            return lodgeClaimProvideExpense;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDateExpenseIncurred(Date dateExpenseIncurred) {
            this.dateExpenseIncurred = dateExpenseIncurred;
        }

        public void setProviderName(String providerName) {
            this.providerName = providerName;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public void setCurrency(CurrencyDTO currency) {
            this.currency = currency;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }

        public void setLodgeClaimProvideExpense(LodgeClaimProvideExpenseDTO lodgeClaimProvideExpense) {
            this.lodgeClaimProvideExpense = lodgeClaimProvideExpense;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFileurl() {
            return fileurl;
        }

        public void setFileurl(String fileurl) {
            this.fileurl = fileurl;
        }
    }

    public String getId() {
        return id;
    }

    public List<LodgeClaimProvideExpenseDTO.ProvideExpenseDTO> getProvideExpense() {
        return provideExpense;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProvideExpense(List<LodgeClaimProvideExpenseDTO.ProvideExpenseDTO> provideExpense) {
        this.provideExpense = provideExpense;
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
