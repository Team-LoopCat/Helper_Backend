package org.example.common.security.spi;

public interface SecurityPort {

    Boolean checkUserIsAuthorized();

    String getCurrentUserId();

    Boolean checkUserIsStudent();
}

