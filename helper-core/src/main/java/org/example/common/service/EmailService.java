package org.example.common.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.example.domain.student.exception.VerifyCodeNotMatchesException;

public interface EmailService {

    void sendEmail(MimeMessage emailForm);

    void checkEmailIsValid(String email);

    MimeMessage makeEmailForm(String content, String requestEmail, String senderEmail);

    void checkCodeMatches(String generatedCode, String RequestCode);
}