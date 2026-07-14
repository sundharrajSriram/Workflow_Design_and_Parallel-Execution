package com.example.eligibility.service;

import com.example.eligibility.model.Customer;
import com.example.eligibility.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerDataService {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ValidationUtil validationUtil;
    
    public Customer getCustomer(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new RuntimeException("Customer not found with ID: " + customerId);
    }
    
    public Customer createCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId().isEmpty()) {
            throw new RuntimeException("Customer ID cannot be null or empty");
        }
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new RuntimeException("Customer name cannot be null or empty");
        }
        validationUtil.validateEmail(customer.getEmail());
        return customerRepository.save(customer);
    }
}