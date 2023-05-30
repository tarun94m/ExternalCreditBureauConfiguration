package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauAmountConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditBureauAmountConfigurationRepository extends JpaRepository<CreditBureauAmountConfiguration,Long> {
}
