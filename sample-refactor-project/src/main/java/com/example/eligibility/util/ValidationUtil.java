package com.example.eligibility.util;

import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {
    
    private static final int MIN_CREDIT_SCORE = 300;
    private static final int MAX_CREDIT_SCORE = 850;
    private static final double MAX_INCOME = 10000000;
    
    /**
     * Validates email format - checks for null/empty and "@" symbol
     * @param email the email to validate
     * @throws RuntimeException if email is null, empty, or doesn't contain "@"
     */
    public void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new RuntimeException("Invalid email format");
        }
    }
    
    /**
     * Validates income - checks for negative values and upper limit
     * @param income the income to validate
     * @throws RuntimeException if income is negative or exceeds the upper limit
     */
    public void validateIncome(double income) {
        if (income < 0) {
            throw new RuntimeException("Income cannot be negative");
        }
        if (income > MAX_INCOME) {
            throw new RuntimeException("Income seems unusually high");
        }
    }
    
    /**
     * Validates credit score - checks for range 300-850
     * @param creditScore the credit score to validate
     * @throws RuntimeException if credit score is outside valid range
     */
    public void validateCreditScore(int creditScore) {
        if (creditScore < MIN_CREDIT_SCORE || creditScore > MAX_CREDIT_SCORE) {
            throw new RuntimeException("Credit score must be between 300 and 850");
        }
    }
    
    /**
     * Generic ID validator - validates ID format with prefix
     * @param id the ID to validate
     * @param prefix the expected prefix (e.g., "CUST", "PROD")
     * @param fieldName the field name for error message
     * @throws RuntimeException if ID is null, empty, or doesn't start with prefix
     */
    public void validateId(String id, String prefix, String fieldName) {
        if (isNullOrEmpty(id)) {
            throw new RuntimeException(fieldName + " cannot be null or empty");
        }
        if (!id.startsWith(prefix)) {
            throw new RuntimeException(fieldName + " must start with " + prefix);
        }
    }
    
    /**
     * Utility method for null/empty checks
     * @param value the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}