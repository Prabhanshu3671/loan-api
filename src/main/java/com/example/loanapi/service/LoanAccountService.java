package com.example.loanapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.loanapi.dto.LoanAccountResponse;
import com.example.loanapi.model.LoanEmi;
import com.example.loanapi.integration.ExternalLoanAccountClient;
import com.example.loanapi.repository.LoanEmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanAccountService {

    private static final Logger logger = LoggerFactory.getLogger(LoanAccountService.class);

    private final LoanEmiRepository repository;
    private final ExternalLoanAccountClient client;

    @Autowired
    public LoanAccountService(LoanEmiRepository repository, ExternalLoanAccountClient client) {
        this.repository = repository;
        this.client = client;
    }

    // Method to get loan account details from the API, save it to the DB, and return the response
    public LoanAccountResponse getLoanAccount(String accountId) {
        // Fetch the loan account data from the external API
        LoanAccountResponse response =  client.fetchLoanAccountDetails(accountId);
        if(response.getErrorMessage() != null) {
            return response;
        }
        for(int i = 0; i < response.getEmiDetails().size(); i++) {
            LoanEmi entity = new LoanEmi();
            entity.setLoanAccountNumber(response.getLoanAccountNumber());
            entity.setMonth(response.getEmiDetails().get(i).getMonth());
            entity.setEmiAmount(response.getEmiDetails().get(i).getEmiAmount());
            entity.setPaidStatus(response.getEmiDetails().get(i).isPaidStatus());
            entity.setDueStatus(response.getEmiDetails().get(i).isDueStatus());
            logger.info("Saving response data : ");
            logger.info("loanAccountNumber : " + entity.getLoanAccountNumber() + ", month : " + entity.getMonth() + ", emiAmount : "
                        + entity.getEmiAmount() + ", paidStatus : " + entity.isPaidStatus() + ", dueStatus : " + entity.isDueStatus());
            repository.save(entity);
        }
        return response;  // Return the LoanAccountResponse to the controller
    }
}
