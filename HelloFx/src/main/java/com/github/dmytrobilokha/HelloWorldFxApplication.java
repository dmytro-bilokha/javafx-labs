package com.github.dmytrobilokha;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HelloWorldFxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text message = new Text("This is Hello World Fx App");
        message.setLayoutY(100);
        message.setTextOrigin(VPos.TOP);
        message.setTextAlignment(TextAlignment.JUSTIFY);
        message.setWrappingWidth(400);
        message.setFill(Color.rgb(187, 195, 107));
        message.setFont(Font.font("SansSerif", FontWeight.BOLD, 24));
        Group messageGroup = new Group(message);
        messageGroup.setLayoutX(200);
        messageGroup.setLayoutY(100);
        messageGroup.setClip(new Rectangle(400, 300));
        Scene scene = new Scene(messageGroup, 500, 400);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }
}
