package org.example.controller;

import org.example.domain.SendEmailRequest;
import org.example.service.EmailServiceClient;
import org.example.service.MessageGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.inject.Inject;

@Controller
@RequestMapping("/email")
public class EmailController {
    private final EmailServiceClient emailServiceClient;
    private final MessageGenerator messageGenerator;

    public EmailController(EmailServiceClient emailServiceClient
    , MessageGenerator messageGenerator) {
        this.emailServiceClient = emailServiceClient;
        this.messageGenerator = messageGenerator;
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail() {
        SendEmailRequest sendEmailRequest = this.messageGenerator.generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);
        return "Success";
    }
}
