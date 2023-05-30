package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType,Long > {
}
