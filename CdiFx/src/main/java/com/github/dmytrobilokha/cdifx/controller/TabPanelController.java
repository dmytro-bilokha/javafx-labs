package com.github.dmytrobilokha.cdifx.controller;

import com.github.dmytrobilokha.cdifx.service.MessageService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class TabPanelController {

    @Inject
    private MessageService messageService;

    public TabPanelController() {
        System.out.println("TabPanelController noargs constructor called");
    }

    public TabPanelController(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("I'm TabPanelController and my message=" + messageService.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("TabPanelController POST INIT");
    }
}
