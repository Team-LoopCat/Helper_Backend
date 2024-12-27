package org.example.domain.student.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.User;
import org.example.domain.student.exception.StudentNotFoundException;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.student.spi.QueryStudentPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStudentServiceImpl implements GetStudentService {
    private final QueryStudentPort studentPort;

    @Override
    public Student getStudentByUserId(User user) {
        return studentPort.getStudentByUserId(user).orElseThrow(
                () -> StudentNotFoundException.EXCEPTION
        );
    }
}
