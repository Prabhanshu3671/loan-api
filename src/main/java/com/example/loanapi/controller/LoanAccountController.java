package com.example.loanapi.controller;

import com.example.loanapi.dto.LoanAccountResponse;
import com.example.loanapi.service.LoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loanaccount")
public class LoanAccountController {

    private final LoanAccountService service;

    @Autowired
    public LoanAccountController(LoanAccountService service) {
        this.service = service;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<LoanAccountResponse> getLoanAccount(@PathVariable String accountId) {
        // Call service to fetch loan account details
        LoanAccountResponse response = service.getLoanAccount(accountId);
        if (response.getErrorMessage() != null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
