package com.github.dmytrobilokha.hellomenu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.ResourceBundle;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    public void actionHandler(ActionEvent actionEvent) {
        System.out.println("Type:" + actionEvent.getEventType());
        System.out.println("Source:" + actionEvent.getSource());
        System.out.println("Target:" + actionEvent.getTarget());
    }

}
