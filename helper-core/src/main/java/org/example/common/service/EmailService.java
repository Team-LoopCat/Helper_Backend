package org.example.common.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface EmailService {

    void sendEmail(MimeMessage emailForm);

    void checkEmailIsValid(String email);

    MimeMessage makeEmailForm(String content, String requestEmail, String senderEmail);
}