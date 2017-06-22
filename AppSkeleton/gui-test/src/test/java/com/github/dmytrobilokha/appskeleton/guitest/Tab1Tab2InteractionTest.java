package com.github.dmytrobilokha.appskeleton.guitest;

import com.github.dmytrobilokha.appskeleton.boot.ContainerManager;
import javafx.fxml.FXMLLoader;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.service.query.impl.NodeQueryUtils.hasText;

import java.util.ResourceBundle;

public class Tab1Tab2InteractionTest extends GuiBaseTestCase {

    private ResourceBundle resources;

    @Test
    public void testGreetingChanges() {
        verifyThat("#nameValueLabel", hasText(resources.getString("undefined_name")));

        clickOn("#name")
                .write("TESTNAME")
                .clickOn("#submitButton");

        verifyThat("#nameValueLabel", hasText("Hello, TESTNAME"));
    }

    @Override
    public void init() throws Exception {
        super.init();
        ContainerManager.startContainer();
        resources = getResources();
    }

    @Override
    public void stop() throws Exception {
        ContainerManager.stopContainer();
        super.stop();
    }

    @Override
    protected String getFxmlLocation() {
        return "/fxml/TabPanel.fxml";
    }

    @Override
    protected FXMLLoader getCustomizedFXMLLoader() {
        return ContainerManager.getBeanByClass(FXMLLoader.class);
    }
}
