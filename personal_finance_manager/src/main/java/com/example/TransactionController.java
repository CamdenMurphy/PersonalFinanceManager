package com.example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.model.Account;
import com.example.model.AccountManager;
import com.example.model.Transaction;

public class TransactionController {

    @FXML
    private ComboBox<Account> accountComboBox;

    @FXML
    private ListView<String> transactionListView;

    private ArrayList<Account> accounts;

    @FXML
    private void initialize() {
        accounts = AccountManager.getInstance().getAccounts();
        accountComboBox.getItems().addAll(accounts);
        accountComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            updateTransactionList(newValue);
        });
    }

    @FXML
    private void handleUploadAction() throws IOException {
        Account selectedAccount = accountComboBox.getSelectionModel().getSelectedItem();
        if (selectedAccount == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Account Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select an account before uploading transactions.");
            alert.showAndWait();
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            uploadTransactions(file, selectedAccount);
        }
    }

    private void uploadTransactions(File csvFile, Account account) {
        try (Scanner scanner = new Scanner(csvFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    // Convert date from a string to LocalDate
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
                    LocalDate date = LocalDate.parse(data[0].trim(), formatter);
                    String description = data[1].trim();
                    double amount = Double.parseDouble(data[2].trim());
                    // System.out.println(date);
                    // System.out.println(description);
                    // System.out.println(amount);
                    Transaction transaction = new Transaction(date, description, amount);
                    account.addTransaction(transaction);
                    AccountManager.getInstance().notifyAccountUpdated();
                }
            }
            updateTransactionList(account);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to Read CSV");
            alert.setContentText("There was an error reading the CSV file.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    private void updateTransactionList(Account selectedAccount) {
        // Clear the listview before updating its contents.
        transactionListView.getItems().clear();

        ArrayList<Transaction> transactions = selectedAccount.getTransactions();

        if (selectedAccount != null && transactions != null) {
            for ( Transaction transaction : transactions ) {
                transactionListView.getItems().add(transaction.toString());
            }
        }
    }

}
