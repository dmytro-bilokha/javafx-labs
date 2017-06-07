package com.github.dmytrobilokha.hellomenu.boot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Loader extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/Menu.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("messages"));
        BorderPane pane = fxmlLoader.load();
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Hello Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
