package org.example.domain.subject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.exception.TeachNotFoundException;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.CheckTeachService;
import org.example.domain.subject.spi.QueryTeachPort;
import org.example.domain.teacher.model.Teacher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckTeachServiceImpl implements CheckTeachService {
    private final QueryTeachPort queryTeachPort;

    @Override
    public void checkTeacherTeachesSubject(Teacher teacher, Subject subject) {
        if (!queryTeachPort.existByTeacherAndSubject(teacher, subject)) {
            throw TeachNotFoundException.EXCEPTION;
        }
    };
}
