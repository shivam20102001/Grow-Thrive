package com.example.growthrive.ui;

import com.example.growthrive.domain.Health;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HealthManagement {
    private VBox healthContainer;
    private Health healthData;

    public HealthManagement() {
        healthContainer = new VBox(10);
        healthData = new Health();
    }

    public VBox getHealthContainer() {
        return healthContainer;
    }

    public void addHealthFeatures() {
        Button waterButton = new Button("Add Water Intake");
        waterButton.setOnAction(e -> increaseWaterIntake());

        Button screenTimeButton = new Button("Add Screen Time");
        screenTimeButton.setOnAction(e -> increaseScreenTime());

        Button breakButton = new Button("Take Break");
        breakButton.setOnAction(e -> takeBreak());

        healthContainer.getChildren().addAll(waterButton, screenTimeButton, breakButton);
    }

    private void increaseWaterIntake() {
        healthData.increaseWaterIntake(250);  // Add 250ml of water intake
        System.out.println("Water intake: " + healthData.getWaterIntake() + " ml");
    }

    private void increaseScreenTime() {
        healthData.addScreenTime(60);  // Add 60 minutes of screen time
        System.out.println("Screen time: " + healthData.getScreenTime() + " minutes");
    }

    private void takeBreak() {
        healthData.takeBreak();
    }
}
