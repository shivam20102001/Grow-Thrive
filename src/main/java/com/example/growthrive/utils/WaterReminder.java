package com.example.growthrive.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class WaterReminder {
    private static final int WATER_REMINDER_INTERVAL = 60; // 1 hour for water reminder

    public static void startWaterReminder() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.hours(WATER_REMINDER_INTERVAL), e -> {
                    // Show a reminder for water intake
                    System.out.println("Time to drink water! Stay hydrated.");
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();
    }
}
