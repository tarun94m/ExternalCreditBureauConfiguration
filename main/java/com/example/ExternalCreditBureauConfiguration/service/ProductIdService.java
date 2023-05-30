package com.example.ExternalCreditBureauConfiguration.service;

import com.example.ExternalCreditBureauConfiguration.entity.ProductId;

import java.util.List;

public interface ProductIdService {
    public ProductId saveProductId(ProductId productId);

    public List<ProductId> findAllProductId();
}
