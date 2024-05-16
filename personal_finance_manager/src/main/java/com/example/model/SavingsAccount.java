package com.example.model;

import java.time.LocalDate;

public class SavingsAccount extends Account {
    
    private Double interestRate;

    public SavingsAccount(String name, Double balance, Double interestRate) {
        super(name, balance);
        this.interestRate = interestRate;
    }

    public String getType() {
        return "Savings Account";
    }

    public void applyMonthlyInterest() {
        double monthlyInterest = getMonthlyInterest();
        Transaction interestTransaction = new Transaction(LocalDate.now(), "Interest Payment", monthlyInterest);
        addTransaction(interestTransaction);
        setBalance(getBalance() + monthlyInterest);
    }

    public Double getMonthlyInterest() {
        double monthlyInterest = getBalance() * (interestRate / 100);
        return monthlyInterest;
    }

    @Override
    public String getReport() {
        applyMonthlyInterest();
        StringBuilder report = new StringBuilder();
        report.append("Account Name: ").append(getName()).append("\n");
        report.append("Type: Checking\n");
        report.append("Balance: $").append(String.format("%.2f", getBalance())).append("\n");
        report.append(String.format("Interest Earned: $%.2f\n", getMonthlyInterest()));

        // Summarize transactions as debits and credits
        report.append("Transactions:\n");
        report.append("Debits (Withdrawals):\n");
        for (Transaction t : getTransactions()) {
            if (t.getAmount() < 0) {
                report.append(String.format("  %s: $%.2f\n", t.getDescription(), t.getAmount()));
            }
        }

        report.append("Credits (Deposits):\n");
        for (Transaction t : getTransactions()) {
            if (t.getAmount() > 0) {
                report.append(String.format("  %s: $%.2f\n", t.getDescription(), t.getAmount()));
            }
        }

        return report.toString();
    }

    @Override
    public void applyTransaction(Transaction transaction) {
        Double amount = transaction.getAmount();
        // Take interest into account per transaction
        // setBalance(getBalance() + amount + (amount * interestRate / 100));
        setBalance(getBalance() + amount);

    }

    public Double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
