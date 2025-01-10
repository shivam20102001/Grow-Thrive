package com.example.growthrive;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        // Set the label text when the button is clicked
        welcomeText.setText("Hello, welcome to GrowThrive!");
    }
}
