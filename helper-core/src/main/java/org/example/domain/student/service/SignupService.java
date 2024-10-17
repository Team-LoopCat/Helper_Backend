package org.example.domain.student.service;

import org.example.domain.student.dto.request.SignupRequestDto;

public interface SignupService {

    void checkUserIdExist(String id);

    void checkEmailExist(String email);

    void checkGradeInfoExist(String grade, String classroom);

    void saveStudent(SignupRequestDto request);
}
