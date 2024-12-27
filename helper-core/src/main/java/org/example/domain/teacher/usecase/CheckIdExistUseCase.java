package org.example.domain.teacher.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.service.CheckUserService;
import org.example.domain.teacher.dto.request.CheckIdExistRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckIdExistUseCase {
    private final CheckUserService checkUserService;

    public void execute(CheckIdExistRequestDto request) {
        checkUserService.checkUserExistsById(request.id());
    }
}
