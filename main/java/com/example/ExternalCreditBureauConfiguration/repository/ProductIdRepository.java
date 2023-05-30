package com.example.ExternalCreditBureauConfiguration.repository;

import com.example.ExternalCreditBureauConfiguration.entity.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIdRepository extends JpaRepository<ProductId,Long> {
}
