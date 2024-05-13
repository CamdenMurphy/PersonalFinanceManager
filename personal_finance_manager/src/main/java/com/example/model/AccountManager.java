package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static AccountManager instance;
    private ArrayList<Account> accounts;
    private List<AccountListener> listeners = new ArrayList<>();

    private AccountManager() {
        accounts = new ArrayList<Account>();

        // Initial Accounts
        Account checking = new CheckingAccount("My Checking", 0.00);
        accounts.add(checking);
        Account savings = new SavingsAccount("My Savings", 0.00, 0.58);
        accounts.add(savings);
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        notifyListeners();
    }

    public void addAccountListener(AccountListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners() {
        for (AccountListener listener : listeners) {
            listener.onAccountUpdated();
        }
    }
}
