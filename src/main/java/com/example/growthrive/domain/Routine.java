package com.example.growthrive.domain;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Routine {
    private String name;
    private List<String> tasks;  // A list of tasks for the daily routine

    public Routine(String name, List<String> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }
}
