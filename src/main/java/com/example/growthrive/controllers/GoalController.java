package com.example.growthrive.controllers;

import com.example.growthrive.domain.Goal;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class GoalController {
    @FXML
    private TextField goalNameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private ChoiceBox<String> goalTypeChoiceBox;
    @FXML
    private TextField groupNameField;
    @FXML
    private TableView<Goal> goalsTable;
    @FXML
    private TableColumn<Goal, String> goalNameColumn;
    @FXML
    private TableColumn<Goal, String> descriptionColumn;
    @FXML
    private TableColumn<Goal, LocalDate> startDateColumn;
    @FXML
    private TableColumn<Goal, LocalDate> endDateColumn;
    @FXML
    private TableColumn<Goal, Boolean> isCompletedColumn;
    @FXML
    private TableColumn<Goal, Integer> pointsColumn;

    public void initialize() {
        goalNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        isCompletedColumn.setCellValueFactory(new PropertyValueFactory<>("isCompleted"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
    }

    @FXML
    private void handleAddGoal() {
        // Add goal logic
    }

    @FXML
    private void handleMarkComplete() {
        // Mark complete logic
    }
}