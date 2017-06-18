package com.github.dmytrobilokha.cdifx.boot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loader extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(Loader.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        ContainerManager.startContainer();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LOG.info("Starting the JavaFX application...");
        FXMLLoader fxmlLoader = ContainerManager.getBeanByClass(FXMLLoader.class);
        if (fxmlLoader == null)
            throw new IllegalStateException("Failed to get FXMLLoader from ContainerManager");
        fxmlLoader.setLocation(getClass().getResource("/fxml/TabPanel.fxml"));
        Parent panel = fxmlLoader.load();
        Scene scene = new Scene(panel, 600, 400);
        primaryStage.setTitle("FXML with CDI example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        ContainerManager.stopContainer();
    }
}
