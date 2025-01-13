package com.example.growthrive.utils;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class GoalTracker {
    public static HBox createGoalForm() {
        HBox goalForm = new HBox(10);

        // Input field for goal description
        TextField goalInput = new TextField();
        goalInput.setPromptText("Enter your goal");

        // Progress bar for the goal
        ProgressBar goalProgress = new ProgressBar(0);

        goalForm.getChildren().addAll(goalInput, goalProgress);
        return goalForm;
    }
}
