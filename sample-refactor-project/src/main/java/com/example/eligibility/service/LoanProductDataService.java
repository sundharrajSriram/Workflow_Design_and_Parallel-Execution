package com.example.eligibility.service;

import com.example.eligibility.model.LoanProduct;
import com.example.eligibility.repository.LoanProductRepository;
import com.example.eligibility.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoanProductDataService {
    @Autowired
    private LoanProductRepository productRepository;
    
    @Autowired
    private ValidationUtil validationUtil;
    
    public LoanProduct getProduct(String productId) {
        Optional<LoanProduct> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RuntimeException("Product not found with ID: " + productId);
    }
    
    public LoanProduct createProduct(LoanProduct product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            throw new RuntimeException("Product ID cannot be null or empty");
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new RuntimeException("Product name cannot be null or empty");
        }
        validationUtil.validateIncome(product.getMinIncome());
        return productRepository.save(product);
    }
}