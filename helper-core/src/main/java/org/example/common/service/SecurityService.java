package org.example.common.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    String getCurrentUserId();

    void checkPasswordMatches(String rawPassword, String encodedPassword);
}
