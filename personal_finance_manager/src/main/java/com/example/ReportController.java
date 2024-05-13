package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ReportController {

    @FXML
    private ListView<String> reportListView;

    private ArrayList<Account> accounts;

    @FXML
    private void initialize() {
        accounts = AccountManager.getInstance().getAccounts();

    }

    @FXML
    private void generateReport() {
        reportListView.getItems().clear();  // Clear existing items
        ArrayList<Account> accounts = AccountManager.getInstance().getAccounts();

        for (Account account : accounts) {
            String reportLine = account.getReport();
            reportListView.getItems().add(reportLine);
        }
    }


    @FXML
    private void exportReport() throws IOException {
        
    }
}

