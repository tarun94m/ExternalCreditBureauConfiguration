package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.CustomerCategoryLink;
import com.example.ExternalCreditBureauConfiguration.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCategoryLinkRepo extends JpaRepository<CustomerCategoryLink, LoanType> {
}
