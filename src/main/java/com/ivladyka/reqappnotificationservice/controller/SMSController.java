package com.ivladyka.reqappnotificationservice.controller;

import com.ivladyka.reqappnotificationservice.model.NotificationRequestTemplate;
import com.ivladyka.reqappnotificationservice.service.SMSService;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SMSController {
    private final SMSService smsService;

    @Autowired
    private SMSController(SMSService smsService) {
        this.smsService = smsService;
    }


    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public Message sendSMS(@RequestBody NotificationRequestTemplate notificationRequestTemplate) {
        return smsService.sendSMS(notificationRequestTemplate.getPhoneNumber(), notificationRequestTemplate.getCode());
    }
}
