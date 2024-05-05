package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void testApplyTransaction() {
        // Format the date for the transaction
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse("4/27/2024", formatter);
        
        // Create mock checking account and transaction
        Account myCheckingAccount = new CheckingAccount("Test Checking Account", 0.0);
        Transaction testTransaction = new Transaction(date, "Groceries", 34.95);
        
        // Apply the transaction and check that the amount is correctly added
        myCheckingAccount.applyTransaction(testTransaction);
        assertEquals(34.95, myCheckingAccount.getBalance(), 
        "Check that the transaction amount is added to the account balance correctly.");
    }
}
