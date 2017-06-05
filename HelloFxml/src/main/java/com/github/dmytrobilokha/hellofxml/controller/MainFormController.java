package com.github.dmytrobilokha.hellofxml.controller;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ResourceBundle;

public class MainFormController {

    @FXML
    private Label nameLabel;
    @FXML
    private TextField name;
    @FXML
    private ResourceBundle resources;

    public void submitHandler(InputEvent event) {
        if (!isEnterEvent(event))
            return;
        String userName = name.getText();
        String hello = resources.getString("hello");
        nameLabel.setText(hello + ", " + userName);
    }

    private boolean isEnterEvent(InputEvent event) {
        String eventName = event.getEventType().getName();
        if ("MOUSE_CLICKED".equals(eventName))
            return true;
        if ("KEY_RELEASED".equals(eventName) && ((KeyEvent) event).getCode() == KeyCode.ENTER)
            return true;
        return false;
    }

}
