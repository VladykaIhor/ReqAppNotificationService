package com.ivladyka.reqappnotificationservice.service;

import com.twilio.rest.api.v2010.account.Message;

public interface SMSService {
    public Message sendSMS(String phoneNumber, String oneTimeCode);
}
