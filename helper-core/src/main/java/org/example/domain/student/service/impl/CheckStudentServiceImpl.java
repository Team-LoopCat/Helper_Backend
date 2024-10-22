package org.example.domain.student.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.exception.EmailAlreadyExistsException;
import org.example.domain.student.exception.StudentNumberAlreadyExistsException;
import org.example.domain.student.service.CheckStudentService;
import org.example.domain.student.spi.QueryStudentPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckStudentServiceImpl implements CheckStudentService {
    private final QueryStudentPort studentPort;

    @Override
    public void checkStudentExistByEmail(String email) {
        if (studentPort.checkStudentExistsByEmail(email)) {
            throw EmailAlreadyExistsException.EXCEPTION;
        }
    }

    @Override
    public void checkStudentNumExist(String studentNum) {
        if (studentPort.checkStudentExistsByStudentNum(studentNum)) {
            throw StudentNumberAlreadyExistsException.EXCEPTION;
        }
    }
}
