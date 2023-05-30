package com.example.ExternalCreditBureauConfiguration.controller;

import com.example.ExternalCreditBureauConfiguration.DTO.CreditBureauConfigurationDTO;
import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauAvailable;
import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauConfiguration;
import com.example.ExternalCreditBureauConfiguration.service.CreditBureauConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditBureauConfigurationController {
    @Autowired
    private CreditBureauConfigurationService creditBureauConfigurationService;

    @PostMapping("/saveCreditBureauConfiguration")
    public CreditBureauConfigurationDTO save(@RequestBody CreditBureauConfigurationDTO creditBureauConfiguration){
        return creditBureauConfigurationService.save(creditBureauConfiguration);
    }

    @PutMapping("/updateById/{id}")
    public CreditBureauConfigurationDTO update(@PathVariable("id") Long id,@RequestBody CreditBureauConfigurationDTO creditBureauConfiguration){
       return creditBureauConfigurationService.update( creditBureauConfiguration,id);
    }
}
