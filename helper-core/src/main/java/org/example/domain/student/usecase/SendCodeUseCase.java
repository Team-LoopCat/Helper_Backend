package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.EmailService;
import org.example.common.service.RedisService;
import org.example.common.util.VerifyCodeUtil;
import org.example.domain.student.dto.request.SendCodeRequestDto;
import org.example.domain.student.exception.EmailSendingException;
import org.springframework.beans.factory.annotation.Value;
import jakarta.mail.MessagingException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class SendCodeUseCase {
    private final EmailService emailService;
    private final RedisService redisService;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void execute(SendCodeRequestDto request) {
        emailService.checkEmailIsValid(request.email());

        String code = VerifyCodeUtil.createRandomCode();

        emailService.sendEmail(
                emailService.makeEmailForm(code, request.email(), senderEmail)
        );

        if (redisService.checkDataExists(request.email())) {
            redisService.deleteData(request.email());
        }
        redisService.setData(request.email(), code, 60 * 5L);
    }
}
