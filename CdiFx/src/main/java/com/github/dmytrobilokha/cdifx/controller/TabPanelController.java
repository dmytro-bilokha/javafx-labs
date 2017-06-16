package com.github.dmytrobilokha.cdifx.controller;

import com.github.dmytrobilokha.cdifx.service.MessageService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class TabPanelController {

    private MessageService messageService;

/*    public TabPanelController() {
        System.out.println("TabPanelController noargs constructor called");
    }*/

    @Inject
    public TabPanelController(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("I'm TabPanelController and my message=" + messageService.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("TabPanelController POST INIT");
    }
}
