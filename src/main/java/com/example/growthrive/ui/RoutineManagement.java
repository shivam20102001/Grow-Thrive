package com.example.growthrive.ui;

import com.example.growthrive.domain.Routine;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class RoutineManagement {
    private VBox routineListContainer;

    public RoutineManagement() {
        routineListContainer = new VBox(10);
    }

    public VBox getRoutineListContainer() {
        return routineListContainer;
    }

    public void addRoutine(String name, List<String> tasks) {
        Routine routine = new Routine(name, tasks);

        VBox routineBox = new VBox(5);
        Button routineButton = new Button("View " + routine.getName());

        for (String task : routine.getTasks()) {
            Button taskButton = new Button(task);
            routineBox.getChildren().add(taskButton);
        }

        routineListContainer.getChildren().add(routineBox);
    }
}
