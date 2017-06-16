package com.github.dmytrobilokha.cdifx.boot;

import com.github.dmytrobilokha.cdifx.controller.TabPanelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;
import org.apache.webbeans.spi.ContextsService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

public class Loader extends Application {

    private ContainerLifecycle lifecycle = null;

    public static void main(String[] args) {
        launch(args);
    }

    public Loader() {
    }

    @Override
    public void init() {
        lifecycle = WebBeansContext.getInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BeanManager beanManager = lifecycle.getBeanManager();
/*        Bean<?> bean = beanManager.getBeans("fXMLLoaderProducer").iterator().next();
        FXMLLoaderProducer producer = (FXMLLoaderProducer) lifecycle.getBeanManager()
                .getReference(bean, FXMLLoaderProducer.class, beanManager.createCreationalContext(bean));
        FXMLLoader fxmlLoader = producer.produce(null);*/
        Bean<?> bean = beanManager.resolve(beanManager.getBeans(FXMLLoader.class));
        FXMLLoader fxmlLoader = (FXMLLoader) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
        System.out.println(Thread.currentThread().getName() + ' ' + Thread.currentThread().getId() + " WE ARE STARTING!!! And fxmlLoader=" + fxmlLoader);
        Callback<Class<?>, Object> controllerFactory = fxmlLoader.getControllerFactory();
        System.out.println("Factory=" + controllerFactory);
        TabPanelController tabPanelController = (TabPanelController) controllerFactory.call(TabPanelController.class);
        System.out.println("Controller=" + tabPanelController);
        fxmlLoader.setLocation(getClass().getResource("/fxml/TabPanel.fxml"));
        Parent panel = fxmlLoader.load(); //getClass().getResource("/fxml/TabPanel.fxml"));
        Scene scene = new Scene(panel, 600, 400);
        primaryStage.setTitle("FXML with CDI example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        lifecycle.stopApplication(null);
    }
}
