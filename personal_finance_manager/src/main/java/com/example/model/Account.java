package com.example.model;

import java.util.ArrayList;

public abstract class Account {
    private String name;
    private Double balance;
    private ArrayList<Transaction> transactions;

    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public abstract void applyTransaction(Transaction transaction);
}
