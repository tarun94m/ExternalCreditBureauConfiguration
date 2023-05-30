package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.CreditBureauAmountLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditBureauAmountLinkRepository extends JpaRepository<CreditBureauAmountLink,Long> {
}
