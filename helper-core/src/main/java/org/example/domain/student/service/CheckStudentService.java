package org.example.domain.student.service;

public interface CheckStudentService {

    void checkStudentExistByEmail(String email);

    void checkStudentNumExist(String studentNum);
}
