package com.example.ExternalCreditBureauConfiguration.controller;

import com.example.ExternalCreditBureauConfiguration.entity.CustomerCategory;
import com.example.ExternalCreditBureauConfiguration.service.CustomerCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerCategoryController {
    @Autowired
    private CustomerCategoryService customerCategoryService;

    @PostMapping("/saveCustomerCategory")
    public CustomerCategory saveCustomerCategory(@RequestBody CustomerCategory customerCategory){
        return customerCategoryService.saveCustomerCategory(customerCategory);
    }

    @GetMapping("/findAllCustomerCategory")
    public List<CustomerCategory> findAll(){
        return customerCategoryService.findAllCustomerCategory();
    }
}
