package org.example.domain.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.spi.SecurityPort;
import org.example.domain.teacher.exception.TeacherNotFoundException;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.GetTeacherService;
import org.example.domain.teacher.spi.QueryTeacherPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTeacherServiceImpl implements GetTeacherService {
    private final SecurityPort securityPort;
    private final QueryTeacherPort queryTeacherPort;

    @Override
    public Teacher getCurrentTeacher() {
        return queryTeacherPort.queryTeacherById(securityPort.getCurrentUserId())
                .orElseThrow(TeacherNotFoundException::new);

    }

    @Override
    public Teacher getTeacherByUserId(String id) {
        return queryTeacherPort.queryTeacherById(id)
                .orElseThrow(TeacherNotFoundException::new);
    }
}
