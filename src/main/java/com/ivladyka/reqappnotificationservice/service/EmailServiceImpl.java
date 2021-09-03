package com.ivladyka.reqappnotificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String email) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("yngwar95@gmail.com");
        simpleMessage.setTo(email);
        simpleMessage.setSubject("Test message to check if the mail notification service works =)");
        simpleMessage.setText("Hi!! This is a test message, you've sent it successfully!");
        javaMailSender.send(simpleMessage);
    }
}
