package com.github.dmytrobilokha.cdifx.boot;

import de.perdoctus.fx.Bundle;
import de.perdoctus.fx.FxWeldApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;

public class Loader extends FxWeldApplication {

    @Inject
    @Bundle("messages")
    private FXMLLoader fxmlLoader;

    @Override
    public void start(Stage primaryStage, Application.Parameters parameters) throws Exception {
        System.out.println("WE ARE STARTING!!!");
        Parent panel = fxmlLoader.load(getClass().getResource("/fxml/TabPanel.fxml"));
        Scene scene = new Scene(panel, 600, 400);
        primaryStage.setTitle("FXML with CDI example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
