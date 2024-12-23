package org.example.domain.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.exception.IdAlreadyExistsException;
import org.example.domain.teacher.service.CheckTeacherService;
import org.example.domain.teacher.spi.QueryTeacherPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckTeacherServiceImpl implements CheckTeacherService {
    private final QueryTeacherPort queryTeacherPort;

    @Override
    public void checkIdExist(String id) {
        if (queryTeacherPort.checkTeacherId(id)) {
            throw IdAlreadyExistsException.EXCEPTION;
        }
    }
}
