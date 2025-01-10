package org.example.domain.student.service;

import org.example.domain.auth.model.User;
import org.example.domain.student.model.Student;

public interface GetStudentService {
  
    Student getStudentByUser(User user);
  
    Student getStudentByStudentId(String studentId);
}
