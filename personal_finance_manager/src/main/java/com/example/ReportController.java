package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.example.model.Account;
import com.example.model.AccountManager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

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
        reportListView.getItems().clear();
        ArrayList<Account> accounts = AccountManager.getInstance().getAccounts();
        
        for (Account account : accounts) {
            reportListView.getItems().add(account.getReport());
        }
    }

    @FXML
    private void exportReport() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.setInitialFileName("Financial_Report.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            writeReportToFile(file);
        }
    }

    private void writeReportToFile(File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            ArrayList<Account> accounts = AccountManager.getInstance().getAccounts();
            for (Account account : accounts) {
                writer.println(account.getReport());
            }
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Not Found");
            alert.setHeaderText(null);
            alert.setContentText("Cant find the file.");
            alert.showAndWait();
        }
    }  
}

