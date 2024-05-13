package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import com.example.model.Account;
import com.example.model.AccountManager;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize the accounts
        initAccountManager();
        
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.setTitle("Personal Finance Manager");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }  

    private void initAccountManager() {
        ArrayList<Account> accounts = AccountManager.getInstance().getAccounts();
    }

    public static void main(String[] args) {
        launch();
    }

}
