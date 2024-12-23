package org.example.domain.teacher.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.dto.request.CheckIdExistRequestDto;
import org.example.domain.teacher.service.CheckTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckIdExistUseCase {
    private final CheckTeacherService checkTeacherService;

    public void execute(CheckIdExistRequestDto request) {
        checkTeacherService.checkIdExist(request.id());
    }
}
