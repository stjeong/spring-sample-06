package org.example.service;

import org.example.domain.SendEmailRequest;
import org.springframework.stereotype.Service;

@Service
public class MessageGenerator {
    public SendEmailRequest generateEmailRequest() {
        return new SendEmailRequest();
    }
}
