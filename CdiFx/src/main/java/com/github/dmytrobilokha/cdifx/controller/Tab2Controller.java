package com.github.dmytrobilokha.cdifx.controller;

import com.github.dmytrobilokha.cdifx.service.MessageService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class Tab2Controller {

    private MessageService messageService;

    @Inject
    public Tab2Controller() {
        System.out.println("Tab2Controller noargs constructor called");
    }

    public Tab2Controller(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("I'm Tab2Controller and my message=" + messageService.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("Tab2Controller POST INIT");
    }
}
