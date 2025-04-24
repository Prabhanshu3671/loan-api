package com.example.loanapi.repository;

import com.example.loanapi.model.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanAccountRepository extends JpaRepository<LoanAccount, String> {
}
