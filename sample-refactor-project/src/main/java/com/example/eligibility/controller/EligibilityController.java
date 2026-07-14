package com.example.eligibility.controller;

import com.example.eligibility.model.Customer;
import com.example.eligibility.model.LoanProduct;
import com.example.eligibility.service.CustomerDataService;
import com.example.eligibility.service.LoanProductDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {
    
    private static final Logger logger = LoggerFactory.getLogger(EligibilityController.class);
    
    @Autowired
    private CustomerDataService customerDataService;
    
    @Autowired
    private LoanProductDataService productDataService;

    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/check/{customerId}/{productId}")
    public String checkEligibility(@PathVariable String customerId, @PathVariable String productId) {
        try {
            Customer customer = customerDataService.getCustomer(customerId);
            LoanProduct product = productDataService.getProduct(productId);

            if (customer.getIncome() >= product.getMinIncome() &&
                customer.getCreditScore() >= product.getMinCreditScore()) {

                // External API call using injected RestTemplate
                String url = UriComponentsBuilder.fromHttpUrl("https://api.external-service.com/validate")
                    .queryParam("customerId", customerId)
                    .toUriString();
                String response = restTemplate.getForObject(url, String.class);
                
                return "Customer " + customer.getName() + " is eligible for " + product.getName();
            } else {
                return "Customer not eligible";
            }
        } catch (Exception e) {
            return "Error checking eligibility: " + e.getMessage();
        }
    }
    
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        Customer created = customerDataService.createCustomer(customer);

        // Send notification
        try {
            restTemplate.postForObject(
                "https://api.notification-service.com/notify",
                customer, 
                String.class
            );
        } catch (Exception e) {
            logger.error("Failed to send notification for customer: {}", customer.getId(), e);
        }
        
        return created;
    }
    
    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        return customerDataService.getCustomer(customerId);
    }
    
    private void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new RuntimeException("Customer ID cannot be null or empty");
        }
        if (!customerId.startsWith("C")) {
            throw new RuntimeException("Customer ID must start with 'C'");
        }
    }
    
    private void validateProductId(String productId) {
        if (productId == null || productId.isEmpty()) {
            throw new RuntimeException("Product ID cannot be null or empty");
        }
        if (!productId.startsWith("LP")) {
            throw new RuntimeException("Product ID must start with 'LP'");
        }
    }
}