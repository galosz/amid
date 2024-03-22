package com.example.animacja2;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        Rectangle kwadrat= new Rectangle(100,100,100,100);
        RotateTransition rotateTransition= new RotateTransition();

        kwadrat.setFill(Color.RED );

        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setCycleCount(50);
        rotateTransition.setNode(kwadrat);

        Button tworca= new Button();
        tworca.setText("TWORCA");
        tworca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Oliwier Gałosz");
                alert.setHeaderText("Twórca");
                alert.show();
            }
        });

        Button start= new Button();
        start.setText("START");
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rotateTransition.play();}
        });
        Button stop= new Button();
        stop.setText("STOP");
        stop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rotateTransition.stop();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(700,500);
        gridPane.setPadding(new Insets(30,30,30,30));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);

        gridPane.add(kwadrat,1,3);
        gridPane.add(start,0,6);
        gridPane.add(stop,0,7);
        gridPane.add(tworca,0,8);

        Group group = new Group(gridPane);
        Scene scene= new Scene(group,750,500);
        scene.setFill(Color.GRAY);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}