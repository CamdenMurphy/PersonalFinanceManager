package com.example.model;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private String description;
    private Double amount;

    public Transaction(LocalDate date, String description, Double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" + 
                "date=" + date + 
                ", description=" + description + 
                ", amount=$" + amount +'}';
    }
}
