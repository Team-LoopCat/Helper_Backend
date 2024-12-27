package org.example.common.service;

import org.example.domain.auth.model.User;

public interface SecurityService {

    String getCurrentUserId();

    User getCurrentUser();

    void checkPasswordMatches(String rawPassword, String encodedPassword);
}
