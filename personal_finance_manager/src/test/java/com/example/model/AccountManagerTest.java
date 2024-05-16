package com.example.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

public class AccountManagerTest {
    @Test
    public void testAccountUpdatesTriggerListener() {
        // Create manager and mock account.
        AccountManager manager = AccountManager.getInstance();
        Account account = new CheckingAccount("Integration Test Account", 200.00);
        
        // Add a listener to the manager. 
        AtomicBoolean wasNotified = new AtomicBoolean(false);
        manager.addAccountListener(() -> wasNotified.set(true));
        
        // Check that the listener gets notified when an account is added to the account manager.
        manager.addAccount(account);
        assertTrue(wasNotified.get());
    }
}
