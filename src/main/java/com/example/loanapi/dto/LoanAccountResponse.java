package com.example.loanapi.dto;

import java.util.List;

public class LoanAccountResponse {

    private String loanAccountNumber;
    private List<EmiDetail> emiDetails;

    public LoanAccountResponse() {}

    public LoanAccountResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public List<EmiDetail> getEmiDetails() {
        return emiDetails;
    }

    public void setEmiDetails(List<EmiDetail> emiDetails) {
        this.emiDetails = emiDetails;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Inner class to represent each EMI detail
    public static class EmiDetail {
        private String month;
        private double emiAmount;
        private boolean paidStatus;
        private boolean dueStatus;

        // Getters and setters
        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public double getEmiAmount() {
            return emiAmount;
        }

        public void setEmiAmount(double emiAmount) {
            this.emiAmount = emiAmount;
        }

        public boolean isPaidStatus() {
            return paidStatus;
        }

        public void setPaidStatus(boolean paidStatus) {
            this.paidStatus = paidStatus;
        }

        public boolean isDueStatus() {
            return dueStatus;
        }

        public void setDueStatus(boolean dueStatus) {
            this.dueStatus = dueStatus;
        }
    }
}

