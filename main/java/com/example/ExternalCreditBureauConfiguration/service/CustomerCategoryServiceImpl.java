package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.CustomerCategory;
import com.example.ExternalCreditBureauConfiguration.repository.CustomerCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCategoryServiceImpl implements CustomerCategoryService{
    @Autowired
    private CustomerCategoryRepository customerCategoryRepository;

    @Override
    public CustomerCategory saveCustomerCategory(CustomerCategory customerCategory) {
        return customerCategoryRepository.save(customerCategory);
    }

    @Override
    public List<CustomerCategory> findAllCustomerCategory() {
        return customerCategoryRepository.findAll();
    }
}
