package org.example.global.security;

import org.example.common.security.spi.SecurityPort;
import org.example.domain.auth.model.Role;
import org.example.global.security.auth.CustomUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityAdapter implements SecurityPort {

    @Override
    public Boolean checkUserIsAuthorized() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof CustomUserDetail;
    }

    @Override
    public String getCurrentUserId() {
        return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).userId();
    }

    @Override
    public Boolean checkUserIsStudent() {
        return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).role() == Role.Student;
    }
}
