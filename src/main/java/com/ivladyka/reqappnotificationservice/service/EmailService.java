package com.ivladyka.reqappnotificationservice.service;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    public void sendEmail(String email);
    public MimeMessage generateMimeMessage();
}
