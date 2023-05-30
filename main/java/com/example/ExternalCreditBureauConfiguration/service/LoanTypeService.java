package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.LoanType;

import java.util.List;

public interface LoanTypeService {
    public LoanType saveLoanTypes(LoanType loanType);

    public List<LoanType> findAllLoanTypes();
}
