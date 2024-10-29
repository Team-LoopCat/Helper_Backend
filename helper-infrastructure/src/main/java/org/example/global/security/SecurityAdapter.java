package org.example.global.security;

import org.example.common.spi.SecurityPort;
import org.example.global.security.auth.CustomUserDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityAdapter implements SecurityPort {

    @Override
    public String getCurrentUserId() {
        return ((CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).userId();
    }
}
