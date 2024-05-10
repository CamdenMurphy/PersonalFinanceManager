package com.example;

import java.util.ArrayList;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DashboardController {

    @FXML
    private ListView<String> overviewListView;

    private ArrayList<Account> accounts;


    @FXML
    private void initialize() {
        accounts = AccountManager.getInstance().getAccounts();
        displayOverview();
    }

    @FXML
    private void displayOverview() {
        for ( Account account : accounts ) {
            String accountEntry = formatAccountEntry(account);
            overviewListView.getItems().add(accountEntry);
        }
    }

    private String formatAccountEntry(Account account) {
        return String.format("%s - $%.2f", account.getName(), account.getBalance());
    }
}
