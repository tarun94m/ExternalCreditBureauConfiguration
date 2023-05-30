package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.States;

import java.util.List;

public interface StatesService {
    public States saveStates(States states);

    public List<States> findAllStates();
}
