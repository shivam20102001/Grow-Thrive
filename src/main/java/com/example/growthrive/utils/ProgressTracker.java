package com.example.growthrive.utils;

import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class ProgressTracker {

    public static VBox createProgressTracker() {
        VBox progressBox = new VBox(10);

        // Create a progress bar for a goal (e.g., learning goal)
        ProgressBar progressBar = new ProgressBar(0.5);  // 50% progress for now
        progressBox.getChildren().add(progressBar);

        return progressBox;
    }
}
