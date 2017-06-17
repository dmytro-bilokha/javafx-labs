package com.github.dmytrobilokha.cdifx.boot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loader extends Application {

    private ContainerManager containerManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        containerManager = new ContainerManager();
        containerManager.startContainer();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = containerManager.getBeanByClass(FXMLLoader.class);
        if (fxmlLoader == null)
            throw new IllegalStateException("Failed to get FXMLLoader from ContainerManager");
        System.out.println(Thread.currentThread().getName() + ' ' + Thread.currentThread().getId() + " WE ARE STARTING!!! And fxmlLoader=" + fxmlLoader);
        fxmlLoader.setLocation(getClass().getResource("/fxml/TabPanel.fxml"));
        Parent panel = fxmlLoader.load();
        Scene scene = new Scene(panel, 600, 400);
        primaryStage.setTitle("FXML with CDI example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("We are stopping...");
        containerManager.stopContainer();
    }
}
