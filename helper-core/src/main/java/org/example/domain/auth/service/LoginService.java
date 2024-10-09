package org.example.domain.auth.service;

import org.example.domain.auth.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface LoginService {
    Optional<User> getUserById(String id);
}
