package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.States;
import com.example.ExternalCreditBureauConfiguration.repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatesServiceImpl implements StatesService{
    @Autowired
    private StatesRepository statesRepository;

    @Override
    public States saveStates(States states) {
        return statesRepository.save(states);
    }

    @Override
    public List<States> findAllStates() {
        return statesRepository.findAll();
    }
}
