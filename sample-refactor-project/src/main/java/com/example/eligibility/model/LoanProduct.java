package com.example.eligibility.model;

public class LoanProduct {
    private String id;
    private String name;
    private double minIncome;
    private double maxLoanAmount;
    private int minCreditScore;
    private double interestRate;
    
    public LoanProduct() {
    }
    
    public LoanProduct(String id, String name, double minIncome, double maxLoanAmount, int minCreditScore, double interestRate) {
        this.id = id;
        this.name = name;
        this.minIncome = minIncome;
        this.maxLoanAmount = maxLoanAmount;
        this.minCreditScore = minCreditScore;
        this.interestRate = interestRate;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getMinIncome() { return minIncome; }
    public void setMinIncome(double minIncome) { this.minIncome = minIncome; }
    
    public double getMaxLoanAmount() { return maxLoanAmount; }
    public void setMaxLoanAmount(double maxLoanAmount) { this.maxLoanAmount = maxLoanAmount; }
    
    public int getMinCreditScore() { return minCreditScore; }
    public void setMinCreditScore(int minCreditScore) { this.minCreditScore = minCreditScore; }
    
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
}