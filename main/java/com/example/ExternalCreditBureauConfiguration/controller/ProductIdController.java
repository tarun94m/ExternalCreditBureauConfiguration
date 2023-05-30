package com.example.ExternalCreditBureauConfiguration.controller;

import com.example.ExternalCreditBureauConfiguration.entity.ProductId;
import com.example.ExternalCreditBureauConfiguration.service.ProductIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductIdController {
    @Autowired
    private ProductIdService productIdService;

    @PostMapping("/saveProductId")
    public ProductId saveProductId(@RequestBody ProductId productId){
        return productIdService.saveProductId(productId);
    }

    @GetMapping("/getProductId")
    public List<ProductId> findAllProductId(){
        return productIdService.findAllProductId();
    }
}
