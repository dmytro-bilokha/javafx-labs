package com.github.dmytrobilokha.hellofxml.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;

import java.util.ResourceBundle;

public class MainFormController {

    @FXML
    private Label nameLabel;
    @FXML
    private TextField name;
    @FXML
    private ResourceBundle resources;

    public void submitHandler(InputEvent event) {
        String userName = name.getText();
        String hello = resources.getString("hello");
        nameLabel.setText(hello + ", " + userName);
    }

}
