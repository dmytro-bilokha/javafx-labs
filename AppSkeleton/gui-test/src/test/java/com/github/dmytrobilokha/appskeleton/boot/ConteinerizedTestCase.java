package com.github.dmytrobilokha.appskeleton.boot;

import com.github.dmytrobilokha.appskeleton.GuiBaseTestCase;
import javafx.fxml.FXMLLoader;

public abstract class ConteinerizedTestCase extends GuiBaseTestCase {

    @Override
    public void init() throws Exception {
        super.init();
        ContainerManager.startContainer();
    }

    @Override
    public void stop() throws Exception {
        ContainerManager.stopContainer();
        super.stop();
    }

    @Override
    protected FXMLLoader getCustomizedFXMLLoader() {
        return ContainerManager.getBeanByClass(FXMLLoader.class);
    }
}
