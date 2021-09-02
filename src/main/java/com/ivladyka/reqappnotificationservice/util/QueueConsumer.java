package com.ivladyka.reqappnotificationservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivladyka.reqappnotificationservice.model.NotificationRequestTemplate;
import com.ivladyka.reqappnotificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

public class QueueConsumer {

    @Autowired
    EmailService emailService;

    public void receiveMessage(String message) {
        System.out.println("Received (String) " + message);
        processMessage(message);
    }

    public void receiveMessage(byte[] message) {
        String strMessage = new String(message);
        System.out.println("Received (String) " + message);
        processMessage(strMessage);
    }

    private void processMessage(String message) {
        try {
            NotificationRequestTemplate notificationRequestTemplate = new ObjectMapper().readValue(message, NotificationRequestTemplate.class);
            emailService.sendEmail(notificationRequestTemplate.getEmail());
        } catch (JsonMappingException e) {
            System.out.println("Bad JSON in message: " + message + "\n" + e);
        } catch (JsonProcessingException e) {
            System.out.println("Cannot map JSON to SMSRequestTemplate: " + message + "\n" + e);

        }
    }
}