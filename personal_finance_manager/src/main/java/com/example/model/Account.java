package com.example.model;

import java.util.ArrayList;

public abstract class Account {
    private String name;
    private Double balance;
    private ArrayList<Transaction> transactions;

    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
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
        applyTransaction(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String toString() {
        return name;
    }

    public String formatAccountString() {
        return String.format("%s - $%.2f", this.getName(), this.getBalance());
    }

    public abstract String getType();
    
    public abstract void applyTransaction(Transaction transaction);
}
