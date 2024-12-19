package org.example.demo4;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

public class HelloController {
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    public void initialize() {
        addhoverEffect(pane1);
        addhoverEffect(pane2);
        addhoverEffect(pane3);
        addhoverEffect(pane4);
        addhoverEffect(pane5);
        addhoverEffect(pane6);
    }

    private void addhoverEffect(Pane pane) {
        pane.setOnMouseEntered(event -> applyScaleTransition(pane,1.0,1.2));
        pane.setOnMouseExited(event -> applyScaleTransition(pane,1.2,1.0));

        pane.setOnMouseClicked(event -> {
            applyRotateTransition(pane);
            changeBackgroundColor(pane);

        });
    }
    private void applyScaleTransition(Pane pane,double fromScale,double toScale) {
        ScaleTransition scaleTransition=new ScaleTransition(Duration.millis(200),pane);
        scaleTransition.setFromX(fromScale);
        scaleTransition.setFromY(fromScale);
        scaleTransition.setToX(toScale);
        scaleTransition.setToY(toScale);
        scaleTransition.play();
    }
    private void applyRotateTransition(Pane pane) {
        RotateTransition rotateTransition=new RotateTransition(Duration.millis(500),pane);
        rotateTransition.setByAngle(360);
        rotateTransition.play();
    }
    private void changeBackgroundColor(Pane pane) {
        Random rand = new Random();
        String randomColor =String.format("#%02X%02X%02X",
                rand.nextInt(256),
                rand.nextInt(256),
                rand.nextInt(256));
        pane.setStyle("-fx-background-color:"+randomColor);

    }


}