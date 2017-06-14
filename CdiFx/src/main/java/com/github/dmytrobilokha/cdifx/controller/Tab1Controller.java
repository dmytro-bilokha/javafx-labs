package com.github.dmytrobilokha.cdifx.controller;

import com.github.dmytrobilokha.cdifx.service.MessageService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class Tab1Controller {

    @Inject
    private MessageService messageService;

    public Tab1Controller() {
        System.out.println("Tab1Controller noargs constructor called");
    }

    public Tab1Controller(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("I'm Tab1Controller and my message=" + messageService.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("Tab1Controller POST INIT");
    }
}
