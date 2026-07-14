package com.example.eligibility.model;

public class Customer {
    private String id;
    private String name;
    private String email;
    private double income;
    private int creditScore;
    private String employmentStatus;
    
    public Customer() {
    }
    
    public Customer(String id, String name, String email, double income, int creditScore, String employmentStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.income = income;
        this.creditScore = creditScore;
        this.employmentStatus = employmentStatus;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }
    
    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int creditScore) { this.creditScore = creditScore; }
    
    public String getEmploymentStatus() { return employmentStatus; }
    public void setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; }
}