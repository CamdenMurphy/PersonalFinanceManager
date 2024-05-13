package com.example;

import java.util.List;
import com.example.model.Account;
import com.example.model.AccountManager;
import com.example.model.CheckingAccount;
import com.example.model.SavingsAccount;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AccountController {

    @FXML
    private ListView<String> accountsListView;

    @FXML
    private ListView<String> detailsListView;

    // New account form
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField balanceTextField;
    @FXML
    private TextField interestTextField;
    
    List<Account> accounts;

    @FXML
    private void initialize() {
        accounts = AccountManager.getInstance().getAccounts();
        updateAccounts();

        // Listener for account selection change
        accountsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateDetails(newValue);
        });

        typeComboBox.getItems().addAll("Checking Account", "Savings Account");
    }

    private void updateAccounts() {
        accountsListView.getItems().clear();

        for ( Account account : accounts ) {
            accountsListView.getItems().add(account.toString());
        }
    }

    @FXML
    private void updateDetails(String accountName) {
        detailsListView.getItems().clear();

        if (accountName != null) {
            // Find the account object from its name
            Account selectedAccount = accounts.stream().filter(account -> account.toString().equals(accountName)).findFirst().orElse(null);
            
            if (selectedAccount != null) {
                // Display the account details
                detailsListView.getItems().add("Name: " + selectedAccount.getName());
                detailsListView.getItems().add("Type: " + selectedAccount.getType());
                detailsListView.getItems().add("Balance: $" + String.format("%.2f", selectedAccount.getBalance()));
                // If it's a savings account, display the interest rate
                if (selectedAccount.getType() == "Savings Account") {
                    SavingsAccount selectedSavingsAccount = (SavingsAccount) selectedAccount;
                    detailsListView.getItems().add("Interest Rate: " + String.format("%.2f%%", selectedSavingsAccount.getInterestRate()));
                }
            }
        }
    }

    @FXML
    private void handleAddAccount() {
        String accountType = typeComboBox.getSelectionModel().getSelectedItem();
        String accountName = nameTextField.getText();
        Double accountBalance = Double.parseDouble(balanceTextField.getText());

        if (accountType == "Checking Account") {
            AccountManager.getInstance().addAccount(new CheckingAccount(accountName, accountBalance));
        }
        else if (accountType == "Savings Account") {
            Double accountInterest = Double.parseDouble(interestTextField.getText());
            AccountManager.getInstance().addAccount(new SavingsAccount(accountName, accountBalance, accountInterest));
        }

        // Reset the selections
        typeComboBox.getSelectionModel().clearSelection();
        nameTextField.clear();
        balanceTextField.clear();
        interestTextField.clear();

        updateAccounts();
    }
    
}