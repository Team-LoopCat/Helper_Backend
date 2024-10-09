package org.example.domain.auth.spi;

import org.example.domain.auth.model.Role;

public interface JwtPort {

    String GenerateAccess(String userId, Role role);
    
    String GenerateRefresh(String userId);
}
