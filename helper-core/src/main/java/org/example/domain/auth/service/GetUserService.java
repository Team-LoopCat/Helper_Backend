package org.example.domain.auth.service;

import org.example.domain.auth.model.User;

public interface GetUserService {

    String getProfileImageById(String id);

    User getUserById(String id);

    User getUserByStudentId(String studentId);
}
