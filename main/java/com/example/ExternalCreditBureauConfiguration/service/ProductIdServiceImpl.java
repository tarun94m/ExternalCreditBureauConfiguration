package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.ProductId;
import com.example.ExternalCreditBureauConfiguration.repository.ProductIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductIdServiceImpl implements ProductIdService{
    @Autowired
    private ProductIdRepository productIdRepository;
    @Override
    public ProductId saveProductId(ProductId productId) {
        return productIdRepository.save(productId);
    }

    @Override
    public List<ProductId> findAllProductId() {
        return productIdRepository.findAll();
    }
}
