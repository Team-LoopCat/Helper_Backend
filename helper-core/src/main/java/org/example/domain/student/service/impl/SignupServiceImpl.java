package org.example.domain.student.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.util.StudentNumberUtil;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.model.User;
import org.example.domain.auth.spi.QueryAuthPort;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.exception.GradeInfoNotExistsException;
import org.example.domain.student.exception.EmailAlreadyExistsException;
import org.example.domain.student.exception.UserIdAlreadyExistsException;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.SignupService;
import org.example.domain.student.spi.QueryGradeInfoPort;
import org.example.domain.student.spi.QueryStudentPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {
    private final QueryAuthPort authPort;
    private final QueryStudentPort studentPort;
    private final QueryGradeInfoPort gradeInfoPort;
    private final StudentNumberUtil studentNumberUtil;

    @Override
    public void checkUserIdExist(String id) {
        if (authPort.getUserById(id).isPresent()) {
            throw UserIdAlreadyExistsException.EXCEPTION;
        }
    }

    @Override
    public void checkEmailExist(String email) {
        if (studentPort.queryUserByEmail(email).isPresent()) {
            throw EmailAlreadyExistsException.EXCEPTION;
        }
    }

    @Override
    public void checkGradeInfoExist(String grade, String classroom) {
        if (!gradeInfoPort.checkGradeInfoExist(grade, classroom)) {
            throw GradeInfoNotExistsException.EXCEPTION;
        }
    }

    @Override
    public void saveStudent(SignupRequestDto request) {
        String studentNum = studentNumberUtil.combination(request.grade(), request.classroom(), request.number());

        Student student = new Student(
            studentNum,
            request.grade(),
            request.classroom(),
            null, // 생성시에는 무조건 subjectId는 empty
            request.id(),
            request.nickname(),
            request.email()
        );

        studentPort.saveStudent(student);
    }
}
