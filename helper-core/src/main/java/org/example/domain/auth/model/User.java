package org.example.domain.auth.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

    private final String userId;

    private final String password;

    private final Role role;

    private final String profile;
}
