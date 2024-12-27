package org.example.global.mail;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.service.EmailService;
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
}
