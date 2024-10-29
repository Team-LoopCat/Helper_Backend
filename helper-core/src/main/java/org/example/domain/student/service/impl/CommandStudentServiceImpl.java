package org.example.domain.student.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.util.StudentNumberUtil;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.CommandStudentService;
import org.example.domain.student.spi.QueryStudentPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandStudentServiceImpl implements CommandStudentService {
    private final QueryStudentPort studentPort;

    @Override
    public void saveStudent(Student student) {
        studentPort.saveStudent(student);
    }
}
