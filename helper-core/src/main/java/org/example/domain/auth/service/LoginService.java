package org.example.domain.auth.service;

import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.model.User;

import java.util.Optional;

public interface LoginService {

    void checkPasswordMatches(String rawPassword, String encodedPassword);
}
