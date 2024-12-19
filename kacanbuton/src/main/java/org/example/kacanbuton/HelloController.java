package org.example.kacanbuton;

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
    private Button yesbutton;
    @FXML
    private Pane pane;

    public void initialize() {
        buttonmove(yesbutton);
        buttonmove(welcomeText);

    }
    @FXML
    private void textupdate(){
        welcomeText.setText("tabikide yakalayamazssın");
    }
    private void buttonmove(Control control) {
        control.setOnMouseEntered(event -> {
            Random rand = new Random();
            Double newX = rand.nextDouble()*pane.getWidth()-control.getWidth();
            Double newY = rand.nextDouble()*pane.getHeight()-control.getHeight();
            control.setLayoutX(newX);
            control.setLayoutY(newY);
        });
    }




}