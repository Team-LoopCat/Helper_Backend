package org.example.domain.student.service;

import org.example.domain.student.dto.request.SignupRequestDto;

public interface CommandStudentService {

    void saveStudent(SignupRequestDto request);
}
