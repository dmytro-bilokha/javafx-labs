package com.github.dmytrobilokha.cdifx.controller;

import com.github.dmytrobilokha.cdifx.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class Tab1Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Tab1Controller.class);

    private MessageService messageService;

    @Inject
    public Tab1Controller(MessageService messageService) {
        LOG.info("Tab1Controller constructor called. And message is '{}'", messageService.getMessage());
        this.messageService = messageService;
    }

    @PostConstruct
    public void init() {
        LOG.info("PostConstruct called");
    }

}
