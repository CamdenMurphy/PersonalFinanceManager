package com.example;

import java.io.IOException;
import java.util.List;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;

public class MainController {

    @FXML private DashboardController dashboardController;
    @FXML private AccountController accountController;
    @FXML private TransactionController transactionController;
    @FXML private ReportController reportController;

    @FXML
    public void initializeUI() throws IOException {
        List<Account> accounts = AccountManager.getInstance().getAccounts();
    }
}
