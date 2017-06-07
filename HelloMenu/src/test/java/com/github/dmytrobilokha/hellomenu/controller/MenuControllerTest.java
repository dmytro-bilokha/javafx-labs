package com.github.dmytrobilokha.hellomenu.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Ignore;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ResourceBundle;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.service.query.impl.NodeQueryUtils.hasText;

@Ignore
public class MenuControllerTest extends ApplicationTest {

    private ResourceBundle resources;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(
                this.getClass().getResource("/fxml/Menu.fxml"));
        resources = ResourceBundle.getBundle("messages");
        fxmlLoader.setResources(resources);
        BorderPane pane = fxmlLoader.load();
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Hello Menu TEST");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
