package com.ivladyka.reqappnotificationservice.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService{
    private static final String ACCOUNT_SID = "ACc6a7aed29b2382cd772b23a041df6842";
    private static final String AUTH_TOKEN = "77f11a4e7c256f1b9cccd8002cbe6309";

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
