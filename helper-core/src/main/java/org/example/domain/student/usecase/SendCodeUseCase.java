package org.example.domain.student.usecase;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.service.EmailService;
import org.example.common.service.RedisService;
import org.example.common.util.VerifyCodeUtil;
import org.example.domain.student.dto.request.SendCodeRequestDto;
import org.example.domain.student.exception.errorCode.EmailSendingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;

@Service
@Transactional
@RequiredArgsConstructor
public class SendCodeUseCase {
    private final EmailService emailService;
    private final RedisService redisService;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    private String setContext(String code) {
        return "<div style='font-size:16px; font-family:Arial, sans-serif;'>" +
                "인증번호: <strong>" + code + "</strong>" +
                "</div>";
    }

    public void execute(SendCodeRequestDto request) {
        String code = VerifyCodeUtil.createRandomCode();

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.addRecipients(MimeMessage.RecipientType.TO, request.email());
            message.setSubject("Helper 인증번호입니다");
            message.setFrom(senderEmail);
            message.setText(setContext(code), "utf-8", "html");

            emailService.sendEmail(message);
        } catch (Exception e) {
            throw EmailSendingException.EXCEPTION;
        }

        if (redisService.checkDataExists(request.email())) {
            redisService.deleteData(request.email());
        }
        redisService.setData(request.email(), code, 60 * 5L);
    }
}
