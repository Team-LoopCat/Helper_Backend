package org.example.common.security.service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

    Boolean checkUserIsAuthorized();

    String getCurrentUserId();

    Boolean checkUserIsStudent();
}
