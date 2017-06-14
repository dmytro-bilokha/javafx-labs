package com.github.dmytrobilokha.nestedfxml.boot;

import com.github.dmytrobilokha.nestedfxml.controller.Tab1Controller;
import com.github.dmytrobilokha.nestedfxml.controller.Tab2Controller;
import com.github.dmytrobilokha.nestedfxml.controller.TabPanelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Loader extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(
                this.getClass().getResource("/fxml/TabPanel.fxml"));
        fxmlLoader.setControllerFactory(aClass -> {
            if (aClass.equals(TabPanelController.class))
                return new TabPanelController("TABPANEL");
            if (aClass.equals(Tab1Controller.class))
                return new Tab1Controller("TAB1");
            if (aClass.equals(Tab2Controller.class))
                return new Tab2Controller("TAB2");
            throw new IllegalArgumentException("Got unknown class " + aClass);
        });
        fxmlLoader.setResources(ResourceBundle.getBundle("messages"));
        Parent panel = fxmlLoader.load();
        Scene scene = new Scene(panel, 600, 400);
        primaryStage.setTitle("Nested FXML example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
