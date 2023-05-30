package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.CustomerCategoryLink;
import com.example.ExternalCreditBureauConfiguration.repository.CustomerCategoryLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCatergoryLinkServiceImpl implements CustomerCategoryLinkService{

    @Autowired
    private CustomerCategoryLinkRepo customerCategoryLinkRepo;
    @Override
    public List<CustomerCategoryLink> findAllCategories() {
        return customerCategoryLinkRepo.findAll();
    }
}
