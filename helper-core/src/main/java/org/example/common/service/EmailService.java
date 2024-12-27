package org.example.common.service;

import jakarta.mail.internet.MimeMessage;

public interface EmailService {
    void sendEmail(MimeMessage emailForm);
}
