package com.example.model;

public class SavingsAccount extends Account {
    
    private Double interestRate;

    public SavingsAccount(String name, Double balance, Double interestRate) {
        super(name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void applyTransaction(Transaction transaction) {
        Double amount = transaction.getAmount();
        // Take interest into account
        setBalance(getBalance() + amount + (amount * interestRate / 100));
    }

    public Double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
