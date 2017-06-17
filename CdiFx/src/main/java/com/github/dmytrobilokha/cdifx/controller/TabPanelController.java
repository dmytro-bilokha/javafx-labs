package com.github.dmytrobilokha.cdifx.controller;

import com.github.dmytrobilokha.cdifx.service.MessageService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class TabPanelController {

    @Inject
    public TabPanelController(MessageService messageService) {
        System.out.println("I'm TabPanelController and my message=" + messageService.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("TabPanelController POST INIT");
    }
}
