package com.example.growthrive.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.LocalTime;

public class SchedulerUIController {
    @FXML
    private TextField timePicker;
    @FXML
    private ComboBox<String> frequencyDropdown;
    @FXML
    private CheckBox goalSchedulerCheckBox;
    @FXML
    private CheckBox healthSchedulerCheckBox;

    public void initialize() {
        // Load saved settings if available
        loadSchedulerSettings();
    }

    @FXML
    public void saveSchedulerSettings() {
        try {
            // Parse time
            LocalTime scheduledTime = LocalTime.parse(timePicker.getText());
            String frequency = frequencyDropdown.getValue();
            boolean isGoalSchedulerEnabled = goalSchedulerCheckBox.isSelected();
            boolean isHealthSchedulerEnabled = healthSchedulerCheckBox.isSelected();

            // Save to database or configuration
            saveToDatabase(scheduledTime, frequency, isGoalSchedulerEnabled, isHealthSchedulerEnabled);

            // Update scheduler dynamically
            applySchedulerSettings(scheduledTime, frequency, isGoalSchedulerEnabled, isHealthSchedulerEnabled);

            System.out.println("Scheduler settings saved and applied.");
        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:mm.");
        }
    }

    private void loadSchedulerSettings() {
        // Load from database or configuration
        // Example:
        // timePicker.setText("00:00");
        // frequencyDropdown.setValue("Daily");
        // goalSchedulerCheckBox.setSelected(true);
        // healthSchedulerCheckBox.setSelected(false);
    }

    private void saveToDatabase(LocalTime scheduledTime, String frequency, boolean goalsEnabled, boolean healthEnabled) {
        // Save scheduler preferences to database or configuration file
        // Example: Insert or update a "scheduler_settings" table
    }

    private void applySchedulerSettings(LocalTime scheduledTime, String frequency, boolean goalsEnabled, boolean healthEnabled) {
        // Adjust the scheduler logic dynamically based on user preferences
        // Example:
        System.out.printf("Scheduler set to run at %s with %s frequency. Goals: %s, Health: %s%n",
                scheduledTime, frequency, goalsEnabled, healthEnabled);
    }
}
