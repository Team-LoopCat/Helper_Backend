package org.example.common.security.service;

import lombok.RequiredArgsConstructor;
import org.example.common.security.spi.SecurityPort;

@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityPort securityPort;

    @Override
    public String getCurrentUserId() {
        return securityPort.getCurrentUserId();
    }
}
