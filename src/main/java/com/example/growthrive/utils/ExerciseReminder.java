package com.example.growthrive.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ExerciseReminder {
    private static final int EXERCISE_INTERVAL = 120; // 2 hours

    public static void startExerciseReminder() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.minutes(EXERCISE_INTERVAL), e -> {
                    // Show a reminder for exercising
                    System.out.println("Time for a quick exercise! Get moving.");
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();
    }
}
