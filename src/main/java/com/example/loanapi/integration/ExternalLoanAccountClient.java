package com.example.loanapi.integration;

import com.example.loanapi.dto.LoanAccountResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalLoanAccountClient {

    private final RestTemplate restTemplate;

    public ExternalLoanAccountClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LoanAccountResponse fetchLoanAccountDetails(String accountId) {
        // External API URL to fetch loan account details
        String url = "http://demo9993930.mockable.io/loanaccount/" + accountId;

        // Send GET request and map response to LoanAccountResponse
        return restTemplate.getForObject(url, LoanAccountResponse.class);
    }
}
