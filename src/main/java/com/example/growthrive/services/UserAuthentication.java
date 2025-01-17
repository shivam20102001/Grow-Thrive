package com.example.growthrive.services;

import com.example.growthrive.utils.AppConfig;
import database.DatabaseManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
@Slf4j
public class UserAuthentication {

    AppConfig config = new AppConfig();

    // Method to authenticate the user
    public boolean authenticateUser(String username, String password) {
        // SQL query to find the user by username
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the username parameter
            stmt.setString(1, username);

            // Execute the query and retrieve the result
            ResultSet resultSet = stmt.executeQuery();

            // If no user is found with the given username
            if (!resultSet.next()) {
                showError("Login Failed","Invalid username","Login Failed: Invalid username.");
                return false;
            }

            // Retrieve user data from the result set
            String storedPassword = resultSet.getString("password");  // Stored password
            boolean isActive = resultSet.getBoolean("is_active");      // User's active status

            // If the user is not active
            if (!isActive) {
                showError("Login Failed","User is deactivated","Login Failed: User is deactivated.");
                return false;
            }

            // Check if the entered password matches the stored password
            if (password.equals(storedPassword)) {
                System.out.println("Login Successful.");
                return true;  // User authenticated successfully
            } else {
                showError("Login Failed","Invalid password","Login Failed: Invalid password.");

                return false;  // Invalid password
            }

        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
            showError("Connection Failed"," Database error","Login Failed: Database error.");

            return false;
        }
    }

    // Helper method to display an error alert
    private void showError(String title, String headerText, String contentText) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
