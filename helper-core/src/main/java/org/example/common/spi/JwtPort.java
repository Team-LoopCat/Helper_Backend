package org.example.common.spi;

import org.example.domain.auth.model.Role;

public interface JwtPort {

    String GenerateAccess(String userId, Role role);
    
    String GenerateRefresh(String userId);
}
