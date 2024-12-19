package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button innerButton;
    @FXML
    private Button lambdaButton;
    @FXML
    private Button anonimButton;

    @FXML
    public void initialize() {
        //inner
        innerButton.setOnAction(new ButtonClickHandler());
        //anonim
        anonimButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                welcomeText.setText("Anonim");
            }
        });
        //lambda
        lambdaButton.setOnAction(Event -> {
            welcomeText.setText("Lambda");
        });

    }
    //scenebuilder
    @FXML
    private void scenebuilderbottunonclick(){
        welcomeText.setText("scenebuilderbottunonclick");
    }
    private class ButtonClickHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            welcomeText.setText("inner");
        }
    }
}