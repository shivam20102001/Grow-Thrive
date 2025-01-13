package com.example.growthrive.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class PostureReminder {
    private static final int POSTURE_INTERVAL = 30; // 30 minutes

    public static void startPostureReminder() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.minutes(POSTURE_INTERVAL), e -> {
                    // Show a reminder for posture correction
                    System.out.println("Time to adjust your posture! Sit up straight.");
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();
    }
}
