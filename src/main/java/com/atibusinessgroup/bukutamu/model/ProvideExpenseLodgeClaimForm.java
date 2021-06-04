package com.atibusinessgroup.bukutamu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class ProvideExpenseLodgeClaimForm {
	private String claimId;

    private List<ProvideExpense> provideExpense = new ArrayList<>();

    public static class ProvideExpense{
    	@DateTimeFormat(pattern = "dd MMM yyyy")
        private Date dateExpenseIncurred;
        private String providerName;
        private String cost;
        private String currency;
        private String remarks;
        private MultipartFile file;
        private String filename;
        private boolean paid;

        public ProvideExpense(){}

        public ProvideExpense(Date dateExpenseIncurred, String providerName, String cost, String currency, String remarks, MultipartFile file, String filename, boolean paid) {
            this.dateExpenseIncurred = dateExpenseIncurred;
            this.providerName = providerName;
            this.cost = cost;
            this.currency = currency;
            this.remarks = remarks;
            this.file = file;
            this.filename = filename;
            this.paid = paid;
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

        public String getCurrency() {
            return currency;
        }

        public boolean isPaid() {
            return paid;
        }

        public String getRemarks() {
            return remarks;
        }

        public MultipartFile getFile() {
            return file;
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

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setFile(MultipartFile file) {
            this.file = file;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

		@Override
		public String toString() {
			return "ProvideExpense [dateExpenseIncurred=" + dateExpenseIncurred + ", providerName=" + providerName
					+ ", cost=" + cost + ", currency=" + currency + ", remarks=" + remarks + ", file=" + file
					+ ", filename=" + filename + ", paid=" + paid + "]";
		}
        
        
    }

    public ProvideExpenseLodgeClaimForm() {
    }

    public List<ProvideExpense> getProvideExpense() {
        return provideExpense;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public void setProvideExpense(List<ProvideExpense> provideExpense) {
        this.provideExpense = provideExpense;
    }
}
