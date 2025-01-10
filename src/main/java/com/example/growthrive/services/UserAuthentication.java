package com.example.growthrive.services;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UserAuthentication {
    public static boolean authenticateUser(String username, String password) {
        // Hardcoded for simplicity, but you can integrate with a database
        if ("admin".equals(username) && "password123".equals(password)) {
            return true;
        }
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText("Invalid credentials");
        alert.setContentText("Please check your username and password.");
        alert.showAndWait();
        return false;
    }
}
