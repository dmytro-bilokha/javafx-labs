package com.github.dmytrobilokha.nestedfxml.controller;

public class TabPanelController {

    public TabPanelController() {
        System.out.println("I'm TabPanelController and my noargs constructor called");
    }

    public TabPanelController(String message) {
        System.out.println("I'm TabPanelController and my constructor called with message=" + message);
    }
}
