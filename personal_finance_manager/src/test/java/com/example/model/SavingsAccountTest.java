package com.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    public void testGetMonthlyInterest() {
        // Create mock checking account and transaction
        SavingsAccount mySavingsAccount = new SavingsAccount("Test Checking Account", 0.0, 0.58);
        Transaction testTransaction1 = new Transaction(LocalDate.now(), "Test transaction 1", 34.95);
        Transaction testTransaction2 = new Transaction(LocalDate.now(), "Test transaction 2", 150.00);
        
        // Apply the mock transactions
        mySavingsAccount.addTransaction(testTransaction1);
        mySavingsAccount.addTransaction(testTransaction2);
        System.out.println(mySavingsAccount.getMonthlyInterest());
        // Check that the correct amount of interest is calculated.
        assertEquals(1.073, mySavingsAccount.getMonthlyInterest(), 0.002, 
        "Check that the correct amount of interest is calculated.");
    }
}
