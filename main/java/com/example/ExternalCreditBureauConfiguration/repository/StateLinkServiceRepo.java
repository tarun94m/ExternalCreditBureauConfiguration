package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.LoanType;
import com.example.ExternalCreditBureauConfiguration.entity.StateLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateLinkServiceRepo extends JpaRepository<StateLink, Long> {
}
