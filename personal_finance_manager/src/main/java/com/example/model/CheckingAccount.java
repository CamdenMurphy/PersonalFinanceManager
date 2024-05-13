package com.example.model;

public class CheckingAccount extends Account {
    
    public CheckingAccount(String name, Double balance) {
        super(name, balance);
    }

    public String getType() {
        return "Checking Account";
    }

    @Override
    public void applyTransaction(Transaction transaction) {
        setBalance(getBalance() + transaction.getAmount());
    }
}
