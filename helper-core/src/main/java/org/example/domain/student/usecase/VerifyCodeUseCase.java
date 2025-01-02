package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.RedisService;
import org.example.common.util.VerifyCodeUtil;
import org.example.domain.student.dto.request.VerifyCodeRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VerifyCodeUseCase {
    private final RedisService redisService;

    public void execute(VerifyCodeRequestDto request) {
        String redisCode = redisService.getData(request.email());

        VerifyCodeUtil.checkCodeExistsInRedis(redisCode);
        VerifyCodeUtil.checkCodeMatches(redisCode, request.code());
    }
}
