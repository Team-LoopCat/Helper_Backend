package org.example.domain.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.CommandTeacherService;
import org.example.domain.teacher.spi.QueryTeacherPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandTeacherServiceImpl implements CommandTeacherService {
    private final QueryTeacherPort queryTeacherPort;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return queryTeacherPort.saveTeacher(teacher);
    }
}
