package org.example.domain.auth.service;

import org.example.domain.auth.model.User;

import java.util.Optional;

public interface SearchUser {

    Optional<User> searchUserById(String userId);
}
