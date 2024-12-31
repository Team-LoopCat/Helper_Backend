package org.example.global.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.service.EmailService;
import org.example.domain.student.exception.EmailNotValidException;
import org.example.domain.student.exception.EmailSendingException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailAdapter implements EmailService {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(MimeMessage emailForm) {
        javaMailSender.send(emailForm);
    }

    @Override
    public void checkEmailIsValid(String email) {
        if (email == null || !email.endsWith(".com")) {
            throw EmailNotValidException.EXCEPTION;
        }
    }

    @Override
    public MimeMessage makeEmailForm(String content, String requestEmail, String senderEmail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.addRecipients(MimeMessage.RecipientType.TO, requestEmail);
            message.setSubject("Helper 인증번호입니다");
            message.setFrom(senderEmail);
            message.setText(setContext(content), "utf-8", "html");

            return message;
        } catch (MessagingException e) {
            throw EmailSendingException.EXCEPTION;
        }
    }

    private String setContext(String code) {
        return "<div style='font-size:16px; font-family:Arial, sans-serif;'>" +
                "인증번호: <strong>" + code + "</strong>" +
                "</div>";
    }
}
