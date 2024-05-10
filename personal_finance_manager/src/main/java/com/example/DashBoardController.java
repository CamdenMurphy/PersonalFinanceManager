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
        // Register DashboardController as a listener
        AccountManager.getInstance().addAccountListener(() -> displayOverview());
        
        accounts = AccountManager.getInstance().getAccounts();
        displayOverview();
    }

    @FXML
    private void displayOverview() {
        // Clear listview before updating it
        overviewListView.getItems().clear();
        
        for ( Account account : accounts ) {
            String accountEntry = account.formatAccountString();
            overviewListView.getItems().add(accountEntry);
        }
    }
}
