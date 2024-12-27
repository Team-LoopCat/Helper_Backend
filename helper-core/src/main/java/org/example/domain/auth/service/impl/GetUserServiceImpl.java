package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.exception.UserNotFoundException;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.GetUserService;
import org.example.domain.auth.spi.QueryAuthPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserServiceImpl implements GetUserService {
    private final QueryAuthPort authPort;

    @Override
    public String getProfileImageById(String id) {
        return getUserById(id).getProfile();
    }

    @Override
    public User getUserById(String id) {
        return authPort.getUserById(id)
             .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
