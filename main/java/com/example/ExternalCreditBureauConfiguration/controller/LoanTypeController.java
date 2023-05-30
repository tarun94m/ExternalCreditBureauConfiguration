package com.example.ExternalCreditBureauConfiguration.controller;

import com.example.ExternalCreditBureauConfiguration.entity.LoanType;
import com.example.ExternalCreditBureauConfiguration.repository.LoanTypeRepository;
import com.example.ExternalCreditBureauConfiguration.service.LoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanTypeController {
    @Autowired
    private LoanTypeService loanTypeService;

    @PostMapping("/saveLoanTypes")
    public LoanType saveLoanTypes(@RequestBody LoanType loanType){
        return loanTypeService.saveLoanTypes(loanType);
    }

    @GetMapping("/findAllLoanTypes")
    public List<LoanType> findAllLoanTypes(){
        return loanTypeService.findAllLoanTypes();
    }
}
