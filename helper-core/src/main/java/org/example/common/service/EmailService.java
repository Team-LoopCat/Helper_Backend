package org.example.common.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface EmailService {

    void sendEmail(MimeMessage emailForm);

    MimeMessage makeEmailForm(String content, String requestEmail, String senderEmail) throws MessagingException;
}