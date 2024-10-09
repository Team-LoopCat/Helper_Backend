package org.example.domain.auth.spi;

import org.example.domain.auth.model.User;

import java.util.Optional;

public interface QueryAuthPort {
    Optional<User> getUserById(String id);
}
