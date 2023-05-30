package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauMiddleConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditBureauMiddleConfigurationRepository extends JpaRepository<CreditBureauMiddleConfiguration,Long> {
}
