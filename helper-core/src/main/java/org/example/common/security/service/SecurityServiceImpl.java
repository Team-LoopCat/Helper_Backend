package org.example.common.security.service;

import lombok.RequiredArgsConstructor;
import org.example.common.security.spi.SecurityPort;

@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityPort securityPort;

    @Override
    public Boolean checkUserIsAuthorized() {
        return securityPort.checkUserIsAuthorized();
    }

    @Override
    public String getCurrentUserId() {
        return securityPort.getCurrentUserId();
    }

    @Override
    public Boolean checkUserIsStudent() {
        return securityPort.checkUserIsStudent();
    }
}
