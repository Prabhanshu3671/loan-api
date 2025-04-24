package com.example.loanapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_account")
public class LoanAccount {

    @Id
    private String loanAccountNumber;  // Primary key: loan account number

    private String dueDate;            // Due date for the loan
    private double emiAmount;          // EMI amount

    // Getters and setters
    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

    // Constructor, toString(), equals(), hashCode() methods can be added as needed
}
