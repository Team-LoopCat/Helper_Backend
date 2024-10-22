package org.example.global.security.auth;

import org.example.domain.auth.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public record TeacherDetail (String userId, Role role) implements CustomUserDetail, UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(
                new SimpleGrantedAuthority(Role.Teacher.name()),
                new SimpleGrantedAuthority(Role.Head.name())
        );
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userId;
    }
}