package com.example.eligibility.repository;

import com.example.eligibility.model.Customer;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();
    
    public CustomerRepository() {
        // Sample data
        customers.put("C001", new Customer("C001", "John Doe", "john@example.com", 75000.0, 720, "EMPLOYED"));
        customers.put("C002", new Customer("C002", "Jane Smith", "jane@example.com", 50000.0, 680, "EMPLOYED"));
        customers.put("C003", new Customer("C003", "Bob Johnson", "bob@example.com", 30000.0, 650, "SELF_EMPLOYED"));
    }
    
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customers.get(id));
    }
    
    public Customer save(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }
    
    public void delete(String id) {
        customers.remove(id);
    }
    
    public Map<String, Customer> findAll() {
        return new HashMap<>(customers);
    }
}