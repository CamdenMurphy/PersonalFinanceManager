package com.example.model;

public class CheckingAccount extends Account {
    
    public CheckingAccount(String name, Double balance) {
        super(name, balance);
    }

    @Override
    public void applyTransaction(Transaction transaction) {
        setBalance(getBalance() + transaction.getAmount());
    }
}
