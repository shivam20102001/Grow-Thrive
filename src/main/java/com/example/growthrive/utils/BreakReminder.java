package com.example.growthrive.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class BreakReminder {

    public static void startBreakReminder() {
        // Create a timeline to remind every 60 minutes to take a break
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.hours(1), e -> {
                    // Show a reminder dialog after each hour
                    System.out.println("Time to take a break and stretch!");
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play();
    }
}
