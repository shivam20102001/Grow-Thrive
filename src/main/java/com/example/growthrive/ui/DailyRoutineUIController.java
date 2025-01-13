package com.example.growthrive.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DailyRoutineUIController {

    @FXML
    private VBox routineListContainer;

    @FXML
    private TextField routineNameField;

    @FXML
    private TextField routineTimeField;

    @FXML
    private Button addRoutineButton;

    @FXML
    private Label gamificationScore;

    private int score = 0; // Gamification points
    private final Map<String, LocalDateTime> routines = new HashMap<>();

    public void initialize() {
        updateGamificationScore();
    }

    @FXML
    public void addRoutine() {
        String routineName = routineNameField.getText();
        String routineTime = routineTimeField.getText();

        if (routineName.isEmpty() || routineTime.isEmpty()) {
            showAlert("Error", "Routine name and time are required.");
            return;
        }

        try {
            LocalDateTime scheduledTime = LocalDateTime.parse(routineTime);

            routines.put(routineName, scheduledTime);
            addRoutineToUI(routineName, scheduledTime);

            routineNameField.clear();
            routineTimeField.clear();
        } catch (Exception e) {
            showAlert("Invalid Time Format", "Time must be in the format yyyy-MM-ddTHH:mm:ss.");
        }
    }

    private void addRoutineToUI(String routineName, LocalDateTime scheduledTime) {
        HBox routineRow = new HBox(10);
        Label routineLabel = new Label(routineName + " (Scheduled: " + scheduledTime + ")");
        Button markDoneButton = new Button("Mark Done");

        markDoneButton.setOnAction(event -> {
            LocalDateTime now = LocalDateTime.now();

            if (now.isBefore(scheduledTime)) {
                score += 10; // Add points for being on time
            } else {
                score -= 5; // Deduct points for being late
            }

            routines.remove(routineName);
            routineListContainer.getChildren().remove(routineRow);
            updateGamificationScore();
        });

        routineRow.getChildren().addAll(routineLabel, markDoneButton);
        routineListContainer.getChildren().add(routineRow);
    }

    private void updateGamificationScore() {
        gamificationScore.setText("Score: " + score);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}