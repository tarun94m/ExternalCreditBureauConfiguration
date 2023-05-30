package com.example.ExternalCreditBureauConfiguration.controller;

import com.example.ExternalCreditBureauConfiguration.entity.States;
import com.example.ExternalCreditBureauConfiguration.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatesController {
    @Autowired
    private StatesService statesService;

    @PostMapping("/saveStates")
    public States saveStates(@RequestBody States states){
        return statesService.saveStates(states);
    }

    @GetMapping("/findAllStates")
    public List<States> findAllStates(){
        return statesService.findAllStates();
    }
}
