package com.example.growthrive.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;


public class Dashboard {
    public PieChart pieChart;
    public LineChart lineChart;


    @FXML
    private void initialize() {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        pieChart.setData(pieChartData);
        pieChart.setClockwise(false);
        pieChart.setStartAngle(180);

        // Create a series of data points
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Series 1");

        // Add data points to the series (x value as String, y value as Number)
        series1.getData().add(new XYChart.Data<>("10", 50));
        series1.getData().add(new XYChart.Data<>("50", 100));
        series1.getData().add(new XYChart.Data<>("150", 50));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Series 2");
        series2.getData().add(new XYChart.Data<>("10", 100));
        series2.getData().add(new XYChart.Data<>("50", 150));
        series2.getData().add(new XYChart.Data<>("150", 100));

        // Add the series to the chart
        lineChart.setData(FXCollections.observableArrayList(series1, series2));
    }

    public void onClickGoal(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/growthrive/Goal.fxml"));
        Parent root = loader.load();

        // Get the current stage using the event's source
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        // Set the new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickRoutine(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/growthrive/Routine.fxml"));
        Parent root = loader.load();

        // Get the current stage using the event's source
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        // Set the new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickList(ActionEvent actionEvent) throws IOException {
        // Get the button that triggered the action
        Button clickedButton = (Button) actionEvent.getSource();

        // Get the text of the button to identify the action
        String buttonText = clickedButton.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/growthrive/"+buttonText+".fxml"));


        // Route based on the button text
//        switch (buttonText) {
//            case "Goal":
//                loader= new FXMLLoader(getClass().getResource("/com/example/growthrive/Goal.fxml"));
//                break;
//            case "Task":
//                loader= new FXMLLoader(getClass().getResource("/com/example/growthrive/Routine.fxml"));
//                break;
//            case "Routine":
//                loader= new FXMLLoader(getClass().getResource("/com/example/growthrive/Routine.fxml"));
//                break;
//            case "Health":
//                loader= new FXMLLoader(getClass().getResource("/com/example/growthrive/Health.fxml"));
//                break;
//            case "Settings":
//                loader= new FXMLLoader(getClass().getResource("/com/example/growthrive/Settings.fxml"));
//                break;
//            default:
//                System.out.println("Unknown action: " + buttonText);
//        }

        Parent root = loader.load();

        // Get the current stage using the event's source
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        // Set the new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

