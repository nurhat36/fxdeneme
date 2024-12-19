package org.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Pane pane;
    @FXML
    private Button nobutton;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to lgbt!");
    }
    public void initialize() {
        nobuttonhareket(nobutton);

    }

    private void nobuttonhareket(Control control) {
        control.setOnMouseEntered(event ->{
            Random rand = new Random();
            double newX = rand.nextDouble()*pane.getWidth()-control.getWidth();
            double newY = rand.nextDouble()*pane.getHeight()-control.getHeight();
            control.setLayoutX(newX);
            control.setLayoutY(newY);
        });
    }
}