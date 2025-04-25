package com.example.loanapi.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.loanapi.dto.LoanAccountResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalLoanAccountClient {

    private static final Logger logger = LoggerFactory.getLogger(ExternalLoanAccountClient.class);

    private final RestTemplate restTemplate;

    public ExternalLoanAccountClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LoanAccountResponse fetchLoanAccountDetails(String accountId) {
        LoanAccountResponse response;
        try {
            // External API URL to fetch loan account details
            String url = "http://demo9993930.mockable.io/loanaccount/" + accountId;

            // Send GET request and map response to LoanAccountResponse
            response = restTemplate.getForObject(url, LoanAccountResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            logger.error("The loan account with ID {} was not found.", accountId);
            response = new LoanAccountResponse("The loan account with ID " + accountId + " was not found.");
        } catch (HttpClientErrorException e) {
            logger.error("An error occurred while fetching the loan account details.");
            response = new LoanAccountResponse("An error occurred while fetching the loan account details.");
        } catch (Exception e) {
            logger.error("An unexpected error occurred. Please try again later.");
            response = new LoanAccountResponse("An unexpected error occurred. Please try again later.");
        }
        return response;
    }
}
