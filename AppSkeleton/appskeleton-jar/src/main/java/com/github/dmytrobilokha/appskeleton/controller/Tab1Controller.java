package com.github.dmytrobilokha.appskeleton.controller;

import com.github.dmytrobilokha.appskeleton.stevent.StEvent;
import com.github.dmytrobilokha.appskeleton.stevent.StEventBus;
import com.github.dmytrobilokha.appskeleton.service.MessageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class Tab1Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Tab1Controller.class);

    @FXML
    private Label nameLabel;
    @FXML
    private TextField name;

    private MessageService messageService;
    private StEventBus eventBus;

    @Inject
    public Tab1Controller(MessageService messageService, StEventBus eventBus) {
        LOG.info("Tab1Controller constructor called. And message is '{}'", messageService.getMessage());
        this.messageService = messageService;
        this.eventBus = eventBus;
    }

    @PostConstruct
    public void init() {
        LOG.info("PostConstruct called");
    }

    public void submitHandler(ActionEvent event) {
        String nameSubmitted = name.getText();
        LOG.info("Submitted name '{}'", nameSubmitted);
        int notified = eventBus.fire(StEvent.of(StEvent.Type.USER_NAME_CHANGED, nameSubmitted));
        LOG.debug("Notified " + notified + " listeners");
    }

}
