package com.ivladyka.reqappnotificationservice.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService{

    @Value("${twilio.account.sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth.token}")
    private String AUTH_TOKEN;

    @Override
    public Message sendSMS(String phoneNumber, String oneTimeCode) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),//The phone number you are sending text to
                        new com.twilio.type.PhoneNumber("+18509056171"),//The Twilio phone number
                        "Your one-time code is: " + oneTimeCode)
                .create();

        return message;
    }

}
