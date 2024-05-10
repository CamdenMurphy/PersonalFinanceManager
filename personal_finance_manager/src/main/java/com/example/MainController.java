package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;

public class MainController {

    @FXML private DashboardController dashboardController;
    @FXML private AccountController accountController;
    @FXML private TransactionController transactionController;
    @FXML private ReportController reportController;

    private ArrayList<Account> accounts;

    @FXML
    public void initializeUI() throws IOException {
        accounts = AccountManager.getInstance().getAccounts();
    }
}
