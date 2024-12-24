package org.example.common.service;

public interface SecurityService {

    String getCurrentUserId();

    void checkPasswordMatches(String rawPassword, String encodedPassword);
}
