package com.example.growthrive.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Health {
    private int waterIntake;  // in milliliters
    private int screenTime;   // in minutes
    private boolean breakReminder;  // Whether the user has taken their break

    public Health() {
        this.waterIntake = 0;
        this.screenTime = 0;
        this.breakReminder = false;
    }

    // Getters and Setters
    public int getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(int waterIntake) {
        this.waterIntake = waterIntake;
    }

    public int getScreenTime() {
        return screenTime;
    }

    public void setScreenTime(int screenTime) {
        this.screenTime = screenTime;
    }

    public boolean isBreakReminder() {
        return breakReminder;
    }

    public void setBreakReminder(boolean breakReminder) {
        this.breakReminder = breakReminder;
    }

    public void increaseWaterIntake(int amount) {
        this.waterIntake += amount;
    }

    public void addScreenTime(int minutes) {
        this.screenTime += minutes;
    }

    public void takeBreak() {
        this.breakReminder = true;
        // Simulate a break for now
        System.out.println("Take a break, stretch, and hydrate!");
    }
}
