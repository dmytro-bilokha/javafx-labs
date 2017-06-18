package com.github.dmytrobilokha.appskeleton.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageService {

    private int messageNumber = 0;

    public MessageService() {
        System.out.println("MessageService constructor called");
    }

    public String getMessage() {
        return "Message number " + messageNumber++;
    }
}
