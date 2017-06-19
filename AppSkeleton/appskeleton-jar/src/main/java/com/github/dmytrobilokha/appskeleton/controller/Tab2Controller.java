package com.github.dmytrobilokha.appskeleton.controller;

import com.github.dmytrobilokha.appskeleton.service.MessageService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Dependent
public class Tab2Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Tab2Controller.class);

    @FXML
    private Label nameValueLabel;

    private MessageService messageService;

    @Inject
    public Tab2Controller(MessageService messageService) {
        LOG.info("Tab2Controller constructor called. And message is '{}'", messageService.getMessage());
        this.messageService = messageService;
    }

    @PostConstruct
    public void init() {
        LOG.info("PostConstruct called");
    }

    public void onNameChange(@Observes String newName) {
        nameValueLabel.setText("Hello " + newName);
    }
}
