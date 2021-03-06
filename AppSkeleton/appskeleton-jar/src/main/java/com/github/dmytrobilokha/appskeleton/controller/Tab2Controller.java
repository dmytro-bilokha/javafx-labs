package com.github.dmytrobilokha.appskeleton.controller;

import com.github.dmytrobilokha.appskeleton.stevent.StEvent;
import com.github.dmytrobilokha.appskeleton.stevent.StEventBus;
import com.github.dmytrobilokha.appskeleton.stevent.StEventListener;
import com.github.dmytrobilokha.appskeleton.service.MessageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class Tab2Controller implements StEventListener<String> {

    private static final Logger LOG = LoggerFactory.getLogger(Tab2Controller.class);

    @FXML
    private Label nameValueLabel;

    private MessageService messageService;
    private StEventBus eventBus;

    @Inject
    public Tab2Controller(MessageService messageService, StEventBus eventBus) {
        LOG.info("Tab2Controller constructor called. And message is '{}'", messageService.getMessage());
        this.messageService = messageService;
        this.eventBus = eventBus;
    }

    @PostConstruct
    public void init() {
        eventBus.subscribe(this, StEvent.Type.USER_NAME_CHANGED);
        LOG.debug("Subscribed to events");
    }

    @PreDestroy
    public void shutDown() {
        LOG.debug("PreDestroy called and message is '{}'", messageService.getMessage()); //It never happens
    }

    public void uselessHandler(ActionEvent event) {
        LOG.debug("Got event {}", event);
    }

    @Override
    public void onStEvent(StEvent<String> stEvent) {
        nameValueLabel.setText("Hello, " + stEvent.getPayload());
    }
}
