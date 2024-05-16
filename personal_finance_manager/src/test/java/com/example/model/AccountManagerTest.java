package com.example.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

public class AccountManagerTest {
    @Test
    public void testAccountUpdatesTriggerListener() {
        AccountManager manager = AccountManager.getInstance();
        Account account = new CheckingAccount("Integration Test Account", 200.00);

        AtomicBoolean wasNotified = new AtomicBoolean(false);
        manager.addAccountListener(() -> wasNotified.set(true));

        manager.addAccount(account);
        
        assertTrue(wasNotified.get());
    }
}
