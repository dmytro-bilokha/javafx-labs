package com.github.dmytrobilokha.cdifx.service;

import javax.inject.Singleton;

@Singleton
public class MessageService {

    private int messageNumber = 0;

    public String getMessage() {
        return "Message number " + messageNumber++;
    }
}
