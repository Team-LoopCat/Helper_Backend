package org.example.domain.auth.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    private final String userId;

    private final String password;

    private final Role role;

    private final String profile;
}
