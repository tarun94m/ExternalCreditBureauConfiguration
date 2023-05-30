package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.LoanType;
import com.example.ExternalCreditBureauConfiguration.repository.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTypeServiceImpl implements LoanTypeService{
    @Autowired
    private LoanTypeRepository loanTypeRepository;
    @Override
    public LoanType saveLoanTypes(LoanType loanType) {
        return loanTypeRepository.save(loanType);
    }

    @Override
    public List<LoanType> findAllLoanTypes() {
        return loanTypeRepository.findAll();
    }
}
