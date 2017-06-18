package com.github.dmytrobilokha.appskeleton.guitest;

import com.github.dmytrobilokha.appskeleton.controller.Tab1Controller;
import com.github.dmytrobilokha.appskeleton.service.MessageService;
import javafx.util.Callback;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class Tab1ControllerTest extends GuiBaseTestCase {

    @Test
    public void testStub() throws InterruptedException {
        Thread.sleep(4000);
        assertTrue(true);
    }

    @Override
    protected String getFxmlLocation() {
        return "/fxml/Tab1.fxml";
    }

    @Override
    protected Callback<Class<?>, Object> getControllerFactory() {
        return new ControllerFactory();
    }

    private class ControllerFactory implements Callback<Class<?>, Object> {

        @Override
        public Object call(Class<?> aClass) {
            MessageService mockMessageService = Mockito.mock(MessageService.class);
            when(mockMessageService.getMessage()).thenReturn("42");
            return new Tab1Controller(mockMessageService);
        }
    }
}
