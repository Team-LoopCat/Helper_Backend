package org.example.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.exception.UserNotFoundException;
import org.example.domain.auth.model.User;
import org.example.domain.auth.spi.QueryAuthPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService {
    private final QueryAuthPort queryAuthPort;

    public CustomUserDetail loadUserByUserId(String userId) throws UserNotFoundException {
        User user = queryAuthPort.getUserById(userId).orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new CustomUserDetail(user.getUserId(), user.getRole());
    }
}
