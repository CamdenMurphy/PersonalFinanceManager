package com.example;

import java.io.IOException;
import java.util.List;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;

public class ReportController {

    @FXML
    private void initialize() {
        List<Account> accounts = AccountManager.getInstance().getAccounts();
    }

    @FXML
    private void generateReport() throws IOException {
        
    }

    @FXML
    private void exportReport() throws IOException {
        
    }
}

