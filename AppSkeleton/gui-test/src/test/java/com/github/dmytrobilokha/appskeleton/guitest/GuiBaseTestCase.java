package com.github.dmytrobilokha.appskeleton.guitest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ResourceBundle;

/**
 * Class used as parent for GUI tests
 */
public abstract class GuiBaseTestCase extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = getFXMLLoader();
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent, 600, 400);
        stage.setTitle("Test " + getClass());
        stage.setScene(scene);
        stage.show();
    }

    protected FXMLLoader getFXMLLoader() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(getFxmlLocation()));
        fxmlLoader.setResources(ResourceBundle.getBundle(getResourcesLocation()));
        Callback<Class<?>, Object> controllerFactory = getControllerFactory();
        if (controllerFactory != null)
            fxmlLoader.setControllerFactory(controllerFactory);
        return fxmlLoader;
    }

    protected abstract String getFxmlLocation();

    protected String getResourcesLocation() {
        return "messages";
    }

    protected Callback<Class<?>, Object> getControllerFactory() {
        return null;
    }
}