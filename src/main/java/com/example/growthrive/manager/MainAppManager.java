package com.example.growthrive.manager;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.example.growthrive.ui.GoalManagement;
import com.example.growthrive.ui.HealthManagement;
import com.example.growthrive.ui.RoutineManagement;

import java.util.List;

public class MainAppManager {

    private final Stage primaryStage;

    public MainAppManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showMainApp() {
        // Create main layout
        BorderPane root = new BorderPane();

        // Instantiate management classes
        GoalManagement goalManagement = new GoalManagement();
        RoutineManagement routineManagement = new RoutineManagement();
        HealthManagement healthManagement = new HealthManagement();

        // Add goals section
        goalManagement.addGoal("Learn JavaFX", "Complete the JavaFX tutorial");

        // Add routine section
        routineManagement.addRoutine("Morning Routine", List.of("Wake up", "Stretch", "Drink Water"));

        // Add health section
        healthManagement.addHealthFeatures();

        // Set sections to the layout
        root.setTop(goalManagement.getGoalListContainer());
        root.setLeft(routineManagement.getRoutineListContainer());
        root.setBottom(healthManagement.getHealthContainer());

        // Create scene
        Scene mainScene = new Scene(root, 800, 600);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Grow & Thrive");
        primaryStage.show();
    }
}
