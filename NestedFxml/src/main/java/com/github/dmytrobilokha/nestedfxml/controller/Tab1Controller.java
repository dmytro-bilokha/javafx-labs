package com.github.dmytrobilokha.nestedfxml.controller;

public class Tab1Controller {

    public Tab1Controller() {
        System.out.println("I'm Tab1Controller and my noargs constructor called");
    }

    public Tab1Controller(String message) {
        System.out.println("I'm Tab1Controller and my constructor called with message=" + message);
    }
}
