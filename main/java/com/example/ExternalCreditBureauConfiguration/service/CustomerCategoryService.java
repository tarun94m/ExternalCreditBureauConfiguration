package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.CustomerCategory;
import java.util.List;

public interface CustomerCategoryService {
    public CustomerCategory saveCustomerCategory(CustomerCategory customerCategory);

    public List<CustomerCategory> findAllCustomerCategory();
}
