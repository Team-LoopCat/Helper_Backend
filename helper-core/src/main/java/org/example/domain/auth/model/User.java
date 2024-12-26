package org.example.domain.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    private final String userId;

    private final String password;

    private final Role role;

    @Builder.Default
    private final String profile = "DEFAULT_IMG_URL";
}
