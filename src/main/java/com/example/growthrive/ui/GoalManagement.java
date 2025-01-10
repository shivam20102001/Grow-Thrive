package com.example.growthrive.ui;

import com.example.growthrive.domain.Goal;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GoalManagement {
    private VBox goalListContainer;

    public GoalManagement() {
        goalListContainer = new VBox(10);
    }

    public VBox getGoalListContainer() {
        return goalListContainer;
    }

    public void addGoal(String name, String description) {
        Goal goal = new Goal(name, description);

        Button goalButton = new Button(name);
        goalButton.setOnAction(e -> markGoalAsCompleted(goal, goalButton));
        goalListContainer.getChildren().add(goalButton);
    }

    private void markGoalAsCompleted(Goal goal, Button goalButton) {
        goal.markAsCompleted();
        goalButton.setStyle("-fx-background-color: green;");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Goal Completed");
        alert.setHeaderText(null);
        alert.setContentText("You have completed the goal: " + goal.getName());
        alert.showAndWait();
    }
}
