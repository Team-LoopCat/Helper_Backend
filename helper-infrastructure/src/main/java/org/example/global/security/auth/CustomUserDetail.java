package org.example.global.security.auth;

import org.example.domain.auth.model.Role;

public interface CustomUserDetail {
    String getUserId();
    Role getRole();
}
