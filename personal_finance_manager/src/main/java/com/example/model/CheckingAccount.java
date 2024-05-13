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

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Account Name: ").append(getName()).append("\n");
        report.append("Type: Checking\n");
        report.append("Balance: $").append(String.format("%.2f", getBalance())).append("\n");

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
        
        // For spacing when showing multiple reports
        report.append("\n\n");

        return report.toString();
    }
}
