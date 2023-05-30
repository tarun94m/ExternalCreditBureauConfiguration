package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.DTO.CreditBureauAvailableDTO;
import com.example.ExternalCreditBureauConfiguration.DTO.CreditBureauConfigurationDTO;
import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauAvailable;
import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauConfiguration;

public interface CreditBureauConfigurationService {
    public CreditBureauConfigurationDTO save(CreditBureauConfigurationDTO creditBureauConfiguration);

    public CreditBureauConfigurationDTO update(CreditBureauConfigurationDTO creditBureauConfiguration, Long id);

//    public CreditBureauConfiguration fetchById(Long id);
}
