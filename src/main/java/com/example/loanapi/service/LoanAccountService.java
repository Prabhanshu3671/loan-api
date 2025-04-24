package com.example.loanapi.service;

import com.example.loanapi.dto.LoanAccountResponse;
import com.example.loanapi.model.LoanAccount;
import com.example.loanapi.repository.LoanAccountRepository;
import com.example.loanapi.integration.ExternalLoanAccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanAccountService {

    private final LoanAccountRepository repository;
    private final ExternalLoanAccountClient client;

    @Autowired
    public LoanAccountService(LoanAccountRepository repository, ExternalLoanAccountClient client) {
        this.repository = repository;
        this.client = client;
    }

    // Method to get loan account details from the API, save it to the DB, and return the response
    public LoanAccountResponse getLoanAccount(String accountId) {
        // Fetch the loan account data from the external API
//        LoanAccountResponse response = client.fetchLoanAccount(accountId);
        LoanAccountResponse response =  client.fetchLoanAccountDetails(accountId);

        // Save the response in the database;
//        LoanAccount entity = new LoanAccount();
//        entity.setLoanAccountNumber(response.getLoanAccountNumber());
//        entity.setDueDate(response.getDueDate());
//        entity.setEmiAmount(response.getEmiAmount());
//
//        repository.save(entity);  // Save the entity to the DB

        return response;  // Return the LoanAccountResponse to the controller
    }
}
