package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.StateLink;
import com.example.ExternalCreditBureauConfiguration.repository.StateLinkServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateLinkServiceImpl implements StateLinkService{
    @Autowired
    private StateLinkServiceRepo stateLinkServiceRepo;

    @Override
    public List<StateLink> findAllStates() {
        return stateLinkServiceRepo.findAll();
    }
}
