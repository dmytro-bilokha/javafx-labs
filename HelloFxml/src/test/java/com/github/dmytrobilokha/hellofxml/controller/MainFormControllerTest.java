package com.github.dmytrobilokha.hellofxml.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ResourceBundle;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.service.query.impl.NodeQueryUtils.hasText;

public class MainFormControllerTest extends ApplicationTest {

    private ResourceBundle resources;

    @Test
    public void testSetsGreetingWithName() {
        verifyThat("#nameLabel", hasText(resources.getString("enter_name")));
        clickOn("#name");
        write("TESTNAME");
        clickOn("#submitButton");
        verifyThat("#nameLabel", hasText(resources.getString("hello") + ", TESTNAME"));
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(
                this.getClass().getResource("/fxml/MainForm.fxml"));
        resources = ResourceBundle.getBundle("messages");
        fxmlLoader.setResources(resources);
        VBox vBox = fxmlLoader.load();
        Scene scene = new Scene(vBox, 600, 400);
        stage.setTitle("Hello FXML");
        stage.setScene(scene);
        stage.show();
    }
}
