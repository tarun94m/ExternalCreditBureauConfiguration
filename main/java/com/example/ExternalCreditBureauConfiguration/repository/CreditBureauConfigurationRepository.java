package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditBureauConfigurationRepository extends JpaRepository<CreditBureauConfiguration,Long> {
}
