package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ReportController {

    @FXML
    private ComboBox<Account> accountComboBox;

    private ArrayList<Account> accounts;

    @FXML
    private void initialize() {
        //AccountManager.getInstance().addAccountListener(() -> updateAccounts());
        accounts = AccountManager.getInstance().getAccounts();

    }

    private void updateAccounts() {
        // accounts = AccountManager.getInstance().getAccounts();
        // accountComboBox.getItems().addAll(accounts);
    }

    @FXML
    private void generateReport() throws IOException {
        
    }

    @FXML
    private void exportReport() throws IOException {
        
    }
}

