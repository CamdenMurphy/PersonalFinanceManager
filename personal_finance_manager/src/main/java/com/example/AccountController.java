package com.example;

import java.util.List;
import com.example.model.Account;
import com.example.model.AccountManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class AccountController {

    @FXML
    private ListView<String> accountsListView;

    @FXML
    private ListView<String> detailsListView;
    
    List<Account> accounts;

    @FXML
    private void initialize() {
        accounts = AccountManager.getInstance().getAccounts();
        updateAccounts();
    }

    private void updateAccounts() {
        accountsListView.getItems().clear();

        for ( Account account : accounts ) {
            accountsListView.getItems().add(account.toString());
        }
    }

    @FXML
    private void handleAddAccount() {
        // TO DO:

        updateAccounts();
    }
    
}