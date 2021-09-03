package com.ivladyka.reqappnotificationservice.controller;


import com.ivladyka.reqappnotificationservice.service.EmailService;
import com.ivladyka.reqappnotificationservice.util.QueueConsumer;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableRabbit
@RestController
public class EmailController {

    private final EmailService emailService;
    private final QueueConsumer queueConsumer;


    @Autowired
    public EmailController(EmailService emailService, QueueConsumer queueConsumer) {
        this.queueConsumer = queueConsumer;
        this.emailService = emailService;
    }

    @PostMapping("/email")
    @RabbitListener(queues = "messagequeue")
    public void sendNotification(@RequestBody String email) {
        queueConsumer.receiveMessage(email);
    }
}
