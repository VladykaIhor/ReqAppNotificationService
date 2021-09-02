package com.ivladyka.reqappnotificationservice.controller;


import com.ivladyka.reqappnotificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @RequestMapping("/email")
    public void sendEmail(@RequestBody String email) {
        emailService.sendEmail();
    }
}
