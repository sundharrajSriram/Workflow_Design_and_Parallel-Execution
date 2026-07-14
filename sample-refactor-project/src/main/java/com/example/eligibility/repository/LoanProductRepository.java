package com.example.eligibility.repository;

import com.example.eligibility.model.LoanProduct;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LoanProductRepository {
    private Map<String, LoanProduct> products = new HashMap<>();
    
    public LoanProductRepository() {
        // Sample data
        products.put("LP001", new LoanProduct("LP001", "Personal Loan", 25000.0, 50000.0, 650, 8.5));
        products.put("LP002", new LoanProduct("LP002", "Home Loan", 50000.0, 500000.0, 700, 7.2));
        products.put("LP003", new LoanProduct("LP003", "Car Loan", 30000.0, 75000.0, 680, 7.8));
    }
    
    public Optional<LoanProduct> findById(String id) {
        return Optional.ofNullable(products.get(id));
    }
    
    public LoanProduct save(LoanProduct product) {
        products.put(product.getId(), product);
        return product;
    }
    
    public void delete(String id) {
        products.remove(id);
    }
    
    public Map<String, LoanProduct> findAll() {
        return new HashMap<>(products);
    }
}