package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;

public class ReportController {

    private ArrayList<Account> accounts;

    @FXML
    private void initialize() {
        accounts = AccountManager.getInstance().getAccounts();
    }

    @FXML
    private void generateReport() throws IOException {
        
    }

    @FXML
    private void exportReport() throws IOException {
        
    }
}

